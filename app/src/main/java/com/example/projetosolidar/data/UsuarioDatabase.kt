package com.example.projetosolidar.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// 7 - criar banco de dados, passando as entities que criei como tabelas que vão compor esse banco.
// Também setamos a versão do banco
@Database(entities = [Usuario::class], version = 1, exportSchema = false)

// 8 - dizer que a classe referencia o Room
abstract class UsuarioDatabase : RoomDatabase() {

    // 9 - método abstrato que recupera UsuarioDao
    abstract fun usuarioDao(): UsuarioDao

    // 10 - recuperar por um companion object o banco do dados inteiro
    companion object {
        // 11 - certificar-se de que não existe nenhuma instancia do Room
        @Volatile
        // 12 - criar variavel visivel para todas as threads do app
        private var INSTANCE: UsuarioDatabase? = null

        // 13 - função que verifica se já existe a instancia
        fun getDatabase(context: Context): UsuarioDatabase {
            val tempInstance = INSTANCE

            // já tem uma instancia? então retorne-a
            if (tempInstance != null) {
                return tempInstance
            }
            // não tem instancia? bo criar ela
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UsuarioDatabase::class.java,
                    "solidar_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
