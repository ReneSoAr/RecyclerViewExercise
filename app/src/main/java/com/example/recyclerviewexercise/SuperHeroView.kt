package com.example.recyclerviewexercise

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recyclerviewexercise.model.SuperHero

@Composable
fun SuperHeroView() {
    val context = LocalContext.current
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        items(getSuperHeroes()) { superhero ->
            ItemHero(superhero = superhero)
            {
                Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
            }
        }
    }

}

@Composable
fun SuperHeroGridView() {
    val context = LocalContext.current
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(vertical = 4.dp, horizontal = 6.dp),
        horizontalArrangement = Arrangement.spacedBy(space = 6.dp),
        verticalArrangement = Arrangement.spacedBy(space = 8.dp)
    ) {
        items(getSuperHeroes()) { superhero ->
            ItemHero(superhero = superhero)
            {
                Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
            }
        }
    }

}

//Encargado de pintar el item
@Composable
fun ItemHero(superhero: SuperHero, onItemSelected:(SuperHero)->Unit) {
    Card(border = BorderStroke(2.dp, Color.Red), modifier = Modifier
        .width(200.dp)
        .clickable { onItemSelected(superhero) }) {
        Column() {
            Image(
                painter = painterResource(id = superhero.photo),
                contentDescription = "super hero avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop)

            Text(text = superhero.superHeroName, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = superhero.realName, modifier = Modifier.align(Alignment.CenterHorizontally), fontSize = 12.sp)
            Text(text = superhero.publisher, fontSize = 10.sp, modifier = Modifier.align(Alignment.End))
        }

    }

}

//Listado creado usando el modelo de datos
fun getSuperHeroes(): List<SuperHero> {
    return listOf(
        SuperHero("Spider man", "Petter Parker", "Marvel", R.drawable.spiderman),
        SuperHero("Wolverine", "Logan", "Marvel", R.drawable.logan),
        SuperHero("Batman", "Bruce Wane", "DC Comics", R.drawable.batman),
        SuperHero("Thor", "Thor Odinson", "Marvel", R.drawable.thor),
        SuperHero("Flash", "Jay Garric", "DC", R.drawable.flash),
        SuperHero("Green lantern", "Alan Scot", "DC", R.drawable.green_lantern),
        SuperHero("Wonder Woman", "Princes Diana", "DC", R.drawable.wonder_woman)
    )
}