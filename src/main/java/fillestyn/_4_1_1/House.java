package fillestyn._4_1_1;

import fillestyn._4_1_2.Book;

/**
 * This class can import Book as long as the scope declaration is public
 * if the keyword public is removed then it means the scope of Book becomes
 * Default and it can no longer be accessed from another package.
 * But other classes in the same package will still be able to access it.
 *
 * Note that House is also have "default" scope, but this is not an issue unless
 * another class wants to import "House"
 *
 * @author fillestyn66
 */
class House {

    Book book;
}
