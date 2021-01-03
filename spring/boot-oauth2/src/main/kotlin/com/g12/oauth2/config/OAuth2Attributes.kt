package com.g12.oauth2.config

import com.g12.oauth2.jpa.entity.UserEntity

class OAuth2Attributes(
        val attributes: Map<String, Any> = emptyMap(),
        val nameAttributeKey: String = "",
        val name: String = "",
        val email: String = "",
        val picture: String = ""
) {
    companion object {
        fun of(registrationId: String, userNameAttributeName: String, attributes: Map<String, Any>): OAuth2Attributes {

            // TODO Refactor rename to ....
            val responsAttirbute = when (registrationId) {
                "naver" -> attributes
                else -> attributes["response"] as Map<String, Object>
            }

            val name = responsAttirbute["name"] as String
            val email = responsAttirbute["email"] as String
            val picture = responsAttirbute["picture"] as String

            return OAuth2Attributes(
                    name = name,
                    email = email,
                    picture = picture,
                    attributes = attributes,
                    nameAttributeKey = userNameAttributeName
            )
        }
    }
}

fun OAuth2Attributes.toUserEntity() = UserEntity(name, email, picture, UserEntity.Role.GUEST)