package hoo.yunhoo.practiceproject.model.user

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverter
import android.arch.persistence.room.TypeConverters
import com.google.gson.Gson


@Entity
data class User(
    @field:PrimaryKey
    val id: Int,
    val name: String,
    val username: String,
    val phone: String,
    val website: String,
//    @TypeConverters(AddressConverter::class)
//    val address: Address,
//    @TypeConverters(CompanyConverter::class)
//    val company: Company,
    val email: String
)

class AddressConverter {
    private var gson: Gson = Gson()
    @TypeConverter
    fun stringToAdress(data: String): Address{
        return gson.fromJson(data, Address::class.java)
    }

    @TypeConverter
    fun addressToString(address: Address): String {
        return gson.toJson(address)
    }
}

class CompanyConverter {
    private var gson: Gson = Gson()
    @TypeConverter
    fun stringToCompany(data: String): Company{
        return gson.fromJson(data, Company::class.java)
    }

    @TypeConverter
    fun companyToString(company: Company): String {
        return gson.toJson(company)
    }
}
