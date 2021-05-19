package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.user

import javax.persistence.Entity
import javax.persistence.Inheritance
import javax.persistence.InheritanceType

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
class Admin : User {


    constructor(fullname: String, password: String, email: String) : super(fullname, password, email)  {
        this.admin = true
    }

    constructor(id:Long?, fullname: String, password: String, email: String) : super(id, fullname, password, email)  {
        this.admin = true
    }

}