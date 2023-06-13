package com.example.kotlindayonedemo.dayfive

val books = mutableListOf(
    Book("The Catcher in the Rye", "0316769487", "Little, Brown and Company", 277),
    Book("To Kill a Mockingbird", "0446310786", "Warner Books", 324),
    Book("1984", "0451524934", "Signet Classics", 328),
    Book("Pride and Prejudice", "0141439513", "Penguin Classics", 416),
    Book("The Great Gatsby", "0743273567", "Scribner", 180),
    Book("One Hundred Years of Solitude", "0060883286", "Harper Perennial Modern Classics", 417),
    Book("Brave New World", "0060850523", "Harper Perennial Modern Classics", 311),
    Book("The Lord of the Rings", "0544003411", "Mariner Books", 1178),
    Book("Animal Farm", "0451526341", "Signet Classics", 144)
)


fun main() {
    val librarian1 = Librarian(1, "Mohamed", "123")
    val borrowedBooks = mutableMapOf<Book, User>()
    val myLibDB = LibraryDataBase(librarian1, books, borrowedBooks)

    val newBook = Book("Clean Code", "0132350882", " Prentice Hall", 464)
    myLibDB.addBook(newBook)
    val user = User(1, "Khaled", "Lower")
    val user2 = User(2, "Ahmed", "Engineer")

    var bookTitle = "1984"

    println("-------Before Lending-------")
    myLibDB.viewAvailableBooks()
    println("Lending.....")
    myLibDB.lendBook(user, bookTitle)

    println("---------After Lending----------")
    myLibDB.viewAvailableBooks()

    println("-----User tries to borrow $bookTitle ---------")
    myLibDB.lendBook(user2, bookTitle)

    myLibDB.receiveBorrowedBook(bookTitle)

    println("-----------After Receiving---------------")
    myLibDB.viewAvailableBooks()

    println("-----User tries to borrow unavailable book ---------")
    bookTitle = "The seven Habits"
    myLibDB.lendBook(user, bookTitle)

}

abstract class LibraryItem(
    val title: String = "NoTitle",
    val iSBN: String = "000-000-0000-000-0000",
    val publication: String = "UnDetermined",
    val numOfPages: Int = 0,
    var isAvailable: Boolean = true
)

class Book(title: String, iSBN: String, publication: String, numOfPages: Int) :
    LibraryItem(title, iSBN, publication, numOfPages)

class Journal : LibraryItem()
class Magazine : LibraryItem()

abstract class LibrarySystemEntity(val id: Int, val name: String)
class User(id: Int, name: String, val job: String = "Undefined") : LibrarySystemEntity(id, name)
class Librarian(id: Int, name: String, val password: String) : LibrarySystemEntity(id, name)


class LibraryDataBase(
    val currentLibrarian: Librarian,
    val availableBooks: MutableList<Book>,
    val borrowedBooks: MutableMap<Book, User>
) {

    fun addBook(book: Book) {
        availableBooks.add(book)
    }

    fun lendBook(user: User, bookTitle: String) {
        try {
            val book = searchForBook(bookTitle)

            if (book.isAvailable) {
                borrowedBooks[book] = user
                availableBooks.remove(book)
                book.isAvailable = false
                println("Return it within the period ☺")
            } else {
                println("Sorry this book is currently Borrowed")
            }
        } catch (e: NoSuchElementException) {
            println("Sorry! this book is unavailable")
        }

    }

    fun viewAvailableBooks() {
        availableBooks.forEach {
            println(it.title)
        }
    }

    private fun searchForBook(bookTitle: String): Book {
        val allBooks = mutableListOf<Book>().apply {
            addAll(availableBooks)
            addAll(borrowedBooks.keys)
        }

        return allBooks.first { book -> book.title == bookTitle }

    }

    fun receiveBorrowedBook(bookTitle: String) {
        val book = borrowedBooks.keys.first() { it.title == bookTitle }
        availableBooks.add(book)
        book.isAvailable = true
        borrowedBooks.remove(book)
    }

}