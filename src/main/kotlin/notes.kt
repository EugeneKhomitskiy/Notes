class Note(
    var id: Int = 0,
    val ownerId: Int,
    var title: String,
    var text: String,
    var comments: Int = 0
)

class Comment(
    var id: Int = 0,
    var noteId: Int,
    val ownerId: Int,
    var message: String,
    val replyTo: Int,
    var del: Boolean = false
)

fun main() {

    val noteService = NotesService()
    val note = Note(ownerId = 0, title = "Заметка 1", text = "Текст заметки 1")
    println("id = ${noteService.add(note)}")
    println("${note.title} ${note.text}")
    val note1 = Note(ownerId = 1, title = "Заметка 2", text = "Текст заметки 2")
    println("id = ${noteService.add(note1)}")
    println("${note1.title} ${note1.text}")
    val note2 = Note(ownerId = 2, title = "Заметка 3", text = "Текст заметки 3")
    println("id = ${noteService.add(note2)}")
    println("${note2.title} ${note2.text}")
    println(noteService.delete(3))
    println(noteService.edit(0, "Измененная заметка 1", "Текст измененной заметки 1"))
    println(note.title)
    //println(noteService.getById(0))
    println(noteService.get())

    val comment = Comment(noteId = 0, ownerId = 0, message = "Comment", replyTo = 0)
    println(noteService.createComment(comment))
    val comment1 = Comment(noteId = 0, ownerId = 0, message = "Comment1", replyTo = 0)
    println(noteService.createComment(comment1))
    val comment2 = Comment(noteId = 0, ownerId = 0, message = "Comment2", replyTo = 0)
    println(noteService.createComment(comment2))

    println(noteService.deleteComment(comment))
    println(comment.del)
    println(comment.message)
    println(noteService.editComment(comment, "Измененный коммент"))

    println(noteService.getComments())

    println(noteService.restoreComments(comment))

    println(noteService.getComments())
}