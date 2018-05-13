package com.qoo.spring5kotlinreactjs.domain.user

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id") val id: Long,
                @Column(name = "name", nullable = false) val name: String,
                @Column(name = "phoneNumber", nullable = false) val phoneNumber: String
)