package recipe.model

import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
open class BaseModel(
    @Id @GeneratedValue var id: Long? = null
) : java.io.Serializable {

    override fun equals(other: Any?): Boolean {

        if (this === other) {
            return true
        }

        if (other == null || this::class !== other::class) {
            return false
        }

        return (other as BaseModel).id == this.id
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: this::class.hashCode()
    }
}