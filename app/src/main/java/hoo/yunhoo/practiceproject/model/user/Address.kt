package hoo.yunhoo.practiceproject.model.user


data class Address(
        val street: String,
        val suite: String,
        val city: String,
        val zipcode: String,
        val geo: Geo
)

data class Geo(
        val lat: String,
        val lng: String
)
