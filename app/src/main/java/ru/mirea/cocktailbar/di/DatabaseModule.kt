package ru.mirea.cocktailbar.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.mirea.cocktailbar.data.dao.CocktailDao
import ru.mirea.cocktailbar.data.dao.IngredientDao
import ru.mirea.cocktailbar.data.database.CocktailsDatabase
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideCocktailsDatabase(@ApplicationContext context: Context): CocktailsDatabase {
        return Room.databaseBuilder(
            context,
            CocktailsDatabase::class.java,
            "cocktails_database"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideCocktailDao(cocktailsDatabase: CocktailsDatabase): CocktailDao {
        return cocktailsDatabase.getCocktailDao()
    }

    @Provides
    fun provideIngredientDao(cocktailsDatabase: CocktailsDatabase): IngredientDao {
        return cocktailsDatabase.getIngredientDao()
    }
}