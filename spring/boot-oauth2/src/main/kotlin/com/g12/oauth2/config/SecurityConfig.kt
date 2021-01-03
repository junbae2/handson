package com.g12.oauth2.config

import com.g12.oauth2.jpa.entity.UserEntity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@EnableWebSecurity
class SecurityConfig(val oAuth2UserService: CustomOAuth2UserService) : WebSecurityConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        // @formatter:off
        http.csrf().disable().headers().frameOptions().disable()
                .and()
                    .authorizeRequests()
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasRole(UserEntity.Role.USER.toString())
                    .anyRequest().authenticated()
                .and()
                    .logout()
                        .logoutSuccessUrl("/logout")
                .and()
                    .oauth2Login()
                        .userInfoEndpoint()
                        .userService(oAuth2UserService)
        // @formatter:on
    }
}