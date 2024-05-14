package br.com.fiap.chllgdb1.database.dao

import android.content.Context
import android.provider.CalendarContract.Instances
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.chllgdb1.model.Usuario

@Database(
    entities = [Usuario::class],
    version = 1
)
abstract class UsuarioDb: RoomDatabase() {

    abstract fun usuarioDao(): UsuarioDao

    companion object{

        private lateinit var instance: UsuarioDb

            fun getDatabase(context: Context): UsuarioDb{
                if (!::instance.isInitialized){
                    instance = Room.databaseBuilder(
                        context,
                        UsuarioDb::class.java,
                        "usuario_db"
                    )
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
                return instance
            }
    }
}