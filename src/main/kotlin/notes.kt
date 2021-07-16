class Note(var id: Int = 0, val ownerId: Int, var title: String, var text: String, var comments: Int = 0)

class Comment(var noteId: Int, val ownerId: Int, val message: String, val replyTo: Int)

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
    println(noteService.edit(0,"Измененная заметка 1", "Текст измененной заметки 1"))
    println(note.title)
    //println(noteService.getById(0))
    println(noteService.get())
}