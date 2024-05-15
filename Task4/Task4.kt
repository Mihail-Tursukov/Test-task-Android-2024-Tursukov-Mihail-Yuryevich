// Интерфейс Наблюдатель
interface Observer {
        // Метод, который вызывается наблюдаемым объектом при наступлении события.
        fun update(news: String)					
}
    
// Интерфейс Наблюдаемый объект
interface Observable {
    fun addObserver(observer: Observer)			// Метод для добавления наблюдателей
    fun removeObserver(observer: Observer)		// Метод для удаления наблюдателей
    fun notifyObservers(news: String)			// Метод для уведомления наблюдателей о событии
}

// Класс NewsPoster, который реализует интерфейс Observable с методами для добавления, удаления и уведомления наблюдателей
class NewsPoster : Observable {
    // Список наблюдателей
    private val observers = mutableListOf<Observer>()	

    // Добавление наблюдателя в список наблюдателей
    override fun addObserver(observer: Observer) {
        observers.add(observer)							
    }

    // Удаление наблюдателя из списка наблюдателей
    override fun removeObserver(observer: Observer) {
        observers.remove(observer)						
    }

    // Уведомление всех наблюдателей о событии
    override fun notifyObservers(news: String) {
        for (observer in observers) {
            observer.update(news)						
        }
    }

    // Метод, выпускающий новость
    // и уведомляющий всех наблюдателей об этом
    fun postNews(news: String) {						
        notifyObservers(news)							
    }
}

// Класс Subscriber, который реализует интерфейс Observer и переопределяет метод update()
class Subscriber(val name: String) : Observer {
    override fun update(news: String) {
        // Вывод получателя и полученной им новости в консоль
        println("$name получил новость: $news")			
    }
}


// Пример функции main()
// 
fun main() {
    val newsPoster = NewsPoster()

    val sub1 = Subscriber("Мишаня")
    val sub2 = Subscriber("Дядя Володя")

    newsPoster.addObserver(sub1)
    newsPoster.postNews("Важная новость, о которой узнает только Мишаня!")
    
    newsPoster.addObserver(sub2)
    newsPoster.postNews("Не менее важная новость всем напоказ!")
    
    newsPoster.removeObserver(sub1)
    newsPoster.postNews("Прескорбная новость: Мишаня отписался от рассылки!")
}
