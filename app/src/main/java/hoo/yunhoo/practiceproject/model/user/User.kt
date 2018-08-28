package hoo.yunhoo.practiceproject.model.user

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity
data class User(
    @field:PrimaryKey
    val id: Int,
    val name: String,
    val username: String,
    val phone: String,
    val website: String,
    val address: Address,
    val company: Company,
    val email: String
)