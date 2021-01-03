package com.g12.oauth2.config

import com.g12.oauth2.jpa.entity.UserEntity
import com.g12.oauth2.jpa.repository.UserRepository
import javax.servlet.http.HttpSession
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService
import org.springframework.security.oauth2.core.OAuth2AuthenticationException
import org.springframework.security.oauth2.core.user.DefaultOAuth2User
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Service

@Service
class CustomOAuth2UserService(
        private val userRepository: UserRepository,
        private val httpSession: HttpSession
) : OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    @Throws(OAuth2AuthenticationException::class)
    override fun loadUser(userRequest: OAuth2UserRequest): OAuth2User {
        val delegate = DefaultOAuth2UserService()
        val oAuth2User = delegate.loadUser(userRequest)

        val registrationId = userRequest.clientRegistration.registrationId
        val userNameAttributeName = userRequest.clientRegistration
                .providerDetails
                .userInfoEndpoint
                .userNameAttributeName

        val attributes = OAuth2Attributes.of(registrationId, userNameAttributeName, oAuth2User.attributes)
        val user = saveOrUpdate(attributes)
        httpSession.setAttribute("user", user.toSessionUser())

        return DefaultOAuth2User(
                listOf(SimpleGrantedAuthority(user.role.roleValue)),
                attributes.attributes,
                attributes.nameAttributeKey

        )
    }

    private fun saveOrUpdate(attributes: OAuth2Attributes): UserEntity {

        val user = userRepository.findByEmail(attributes.email) ?: attributes.toUserEntity()

        user.name = attributes.name
        user.picture = attributes.picture

        return userRepository.save(user)
    }
}