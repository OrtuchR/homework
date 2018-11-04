package com.gmail.ortuchr.data.repositories.hw11

import android.os.SystemClock
import android.util.Log
import com.gmail.ortuchr.data.entity.transformToDomain
import com.gmail.ortuchr.data.net.RestService
import com.gmail.ortuchr.domain.entity.hw11.Student
import com.gmail.ortuchr.domain.entity.hw11.StudentAdd
import com.gmail.ortuchr.domain.entity.hw11.StudentDelete
import com.gmail.ortuchr.domain.entity.hw11.StudentSearch
import com.gmail.ortuchr.domain.repositories.hw11.StudentRepository
import io.reactivex.Completable
import io.reactivex.Observable

class StudentRepositoryImpl(val apiService: RestService) : StudentRepository {
    override fun get(): Observable<List<Student>> {
        return apiService.getStudents()
                .map { list ->
                    list.map { student -> student.transformToDomain() }
                }}

    override fun get(id: String): Observable<Student> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun search(search: StudentSearch): Observable<List<Student>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(student: Student): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(delete: StudentDelete): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun add(add: StudentAdd): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /*companion object {
        val list = mutableListOf<Student>()
    }

    private fun getList() : MutableList<Student> {
        if (list.isEmpty()) {
            list.add(Student("0", "Иван Иванов", 18, "https://hornews.com/upload/images/akter.jpeg.pagespeed.ce.cjK81FuZxR.jpg"))
            list.add(Student("1", "Петр Петров", 24, "https://avatarko.ru/img/kartinka/8/muzhchina_glaza_7472.jpg"))
            list.add(Student("2", "Василий Теркин", 29, "https://images.wallpaperscraft.ru/image/tom_khardi_muzhchina_akter_znamenitost_101537_300x168.jpg"))
            list.add(Student("3", "Анатолий Круглый", 33, "https://www.theplace.ru/archive/Sergey_bezrukov/img/4-84.jpg"))
            list.add(Student("4", "Антон Климов", 31, "https://f3.mylove.ru/FLDheGrmMH.jpg"))
            list.add(Student("5", "Владимир Пржевальский", 19, "https://www.famousbirthdays.com/faces/durov-pavel-image.jpg"))
        }
        return list
    }

    override fun get(): Observable<List<Student>> {
        return Observable.just(getList())
    }

    override fun get(id: String): Observable<Student> {
        var searchStudent = Student("", "", 0, "")
        for (student: Student in list) {
            if (student.id.equals(id))
                searchStudent = student
        }
        return Observable.just(searchStudent)
    }

    override fun search(search: StudentSearch): Observable<List<Student>> {
        if (search.name.isEmpty()) {
            return Observable.just(list)
        }
        val searchList = mutableListOf<Student>()
        for (student: Student in list) {
            if (search.name.length <= student.name.length &&
                    student.name.substring(0, search.name.length).equals(search.name, true)) {
                    searchList.add(student)
            }
        }
        return Observable.just(searchList)
    }

    override fun update(student: Student): Completable {
        for (studentInList: Student in list) {
            if (studentInList.id.equals(student.id)) {
                val index = list.indexOf(studentInList)
                list.set(index, student)
                continue
            }
        }
        return Completable.complete()
    }

    override fun delete(delete: StudentDelete): Completable {
        val deleteList = mutableListOf<Student>()
        for (student: Student in list) {
            if (student.id.equals(delete.id)) {
                deleteList.add(student)
                continue
            }
        }
        list.removeAll(deleteList)
        return Completable.complete()
    }

    override fun add(add: StudentAdd): Completable {
        list.add(Student(SystemClock.currentThreadTimeMillis().toString(), add.name, add.age, add.url))
        return Completable.complete()
    }*/
}