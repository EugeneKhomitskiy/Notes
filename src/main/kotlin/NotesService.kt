interface CrudService<T> {
    fun add(element: T): Int
    fun delete(id: Int): String
    fun edit(id: Int, title: String, text: String): String
    fun getById(id: Int): String
}

class NotesService : CrudService<Note> {
    var notes: MutableList<Note> = mutableListOf()
    var comments: MutableList<Comment> = mutableListOf()

    override fun add(element: Note): Int {
        element.id = notes.size
        notes.add(element)
        return notes.last().id
    }

    override fun delete(id: Int): String {
        return try {
            notes.removeAt(id)
            "1"
        } catch (e: IndexOutOfBoundsException) {
            "Заметка не найдена"
        }
    }

    override fun edit(id: Int, title: String, text: String): String {
        return try {
            notes[id].text = text
            notes[id].title = title
            "1"
        } catch (e: IndexOutOfBoundsException) {
            "Заметка не найдена"
        }
    }

    override fun getById(id: Int): String {
        return try {
            notes[id].toString()
        } catch (e: IndexOutOfBoundsException) {
            "Заметка не найдена"
        }
    }
}