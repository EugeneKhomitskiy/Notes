interface CrudService<T> {
    fun add(element: T): Int
    fun delete(id: Int): String
    fun edit(id: Int, title: String, text: String): String
    fun getById(id: Int): String
    fun get()
}

class NotesService : CrudService<Note> {
    private var notes: MutableList<Note> = mutableListOf()
    private var comments: MutableList<Comment> = mutableListOf()

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

    override fun get() {
        for ((index) in notes.withIndex()) {
            println(notes[index])
        }
    }

    fun createComment() {}
    fun deleteComment() {}
    fun editComment() {}
    fun getComments() {}
    fun restoreComments() {}

}