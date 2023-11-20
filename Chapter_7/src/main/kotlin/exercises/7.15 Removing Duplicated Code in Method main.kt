package exercises

import exercises.Account.Companion.displayAccount

fun main(args: Array<String>) {
//  val accountTest = AccountTest()
    val account = Account("User 1", 0.0)
    val account2 = Account("User 2", 0.0)

    displayAccount(account)
    displayAccount(account2)

    // Order the name of accounts
    println("Please enter the name Account 1:")
    var inputName = readlnOrNull() ?: "User"
    account.name = inputName

    println("Please enter the name Account 2:")
    inputName = readlnOrNull() ?: "User"
    account2.name = inputName

    // Order the new deposit for accounts
    println("Enter deposit amount for account1:")
    var inputDeposit = readlnOrNull()?.toDouble() ?: 0.0
    account.deposit(inputDeposit)

    println("Enter deposit amount for account2:")
    inputDeposit = readlnOrNull()?.toDouble() ?: 0.0
    account2.deposit(inputDeposit)

    // Show the value of the balance after deposit
    displayAccount(account)
    displayAccount(account2)
}

// Class to control just the display account
// She receive a object
//class AccountTest {
//    fun displayAccount(accountToDisplay: Account) {
//        println("${accountToDisplay.name} \nBalance ${accountToDisplay.balance}")
//    }
//}

class Account(val initialName: String, initialDeposit: Double) { // Primary Constructor
    var name: String? = initialName
        set(value) {
            field = value
        }

    var balance = initialDeposit
        private set

    init {
        require(initialDeposit >= 0.0) { "This quantity it's not permitted." }
    }

    fun deposit(newDeposit: Double) {
        balance += newDeposit
    }

    fun withDraw(newWithDraw: Double) {
        balance -= newWithDraw
    }

    // Format the value for 2 floating points
    fun balanceToString(): String {
        return String.format("%.2f", balance)
    }

    // Using Companion Object
    companion object {
        fun displayAccount(accountToDisplay: Account) {
            println("${accountToDisplay.name} \nBalance ${accountToDisplay.balance}")
        }
    }
}
