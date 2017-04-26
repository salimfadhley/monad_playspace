import monocle.Lens
import monocle.macros.GenLens
import monocle.function.Cons.headOption // to use headOption (an optic from Cons typeclass)


case class Street(number: Int, name: String)
case class Address(city: String, street: Street)
case class Company(name: String, address: Address)
case class Employee(name: String, company: Company)

val company   : Lens[Employee, Company] = GenLens[Employee](_.company)
val address   : Lens[Company , Address] = GenLens[Company](_.address)
val street    : Lens[Address , Street]  = GenLens[Address](_.street)
val streetName: Lens[Street  , String]  = GenLens[Street](_.name)


val employee = Employee("john", Company("awesome inc", Address("london", Street(23, "high street"))))

employee.copy(
  company = employee.company.copy(
    address = employee.company.address.copy(
      street = employee.company.address.street.copy(
        name = employee.company.address.street.name.capitalize // luckily capitalize exists
      )
    )
  )
)

(company composeLens address composeLens street composeLens streetName).modify(_.capitalize)(employee)
