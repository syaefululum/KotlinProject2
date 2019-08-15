package com.cdc.kotlinproject2.Material

interface Lendable {
    fun borrow()
}

abstract class InventoryItem(
    val title: String,
    val genre: String,
    var publicationYear: Int,
    var borrowed: Boolean
) : Lendable {

    override fun borrow() {
        if (!borrowed) {
            borrowed = true
        } else {
            println("This item is already borrowed.")
        }
    }

    override fun toString(): String {
        return "InventoryItem(title='$title', genre='$genre', publicationYear=$publicationYear, borrowed=$borrowed)"
    }

    abstract fun copy(): InventoryItem

}

class LibraryBook(
    title: String,
    val author: String,
    genre: String,
    publicationYear: Int
) : InventoryItem(title, genre, publicationYear, false) {

    fun read() {
        println("Reading a book by $author...")
    }

    override fun copy(): InventoryItem {
        val copy = LibraryBook(title, author, genre, publicationYear)
        copy.borrowed = this.borrowed

        return copy
    }
}

// A DVD will also be not borrowed by default.
class LibraryDVD(
    title: String,
    genre: String,
    val length: Int,
    publicationYear: Int
) : InventoryItem(title, genre, publicationYear, false) {

    fun watch() {
        println("Watching $title...")
    }

    override fun copy(): InventoryItem {
        val copy = LibraryDVD(title, genre, length, publicationYear)
        copy.borrowed = this.borrowed

        return copy
    }
}
