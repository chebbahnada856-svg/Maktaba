package com.ElOuedUniv.maktaba.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ElOuedUniv.maktaba.presentation.viewmodel.BookViewModel

@Composable
fun BookListScreen(viewModel: BookViewModel) {
    val books by viewModel.books.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {

        // ✅ Bonus 1: Counter
        Text(
            text = "Total Books: ${books.size}",
            style = MaterialTheme.typography.titleMedium
        )

        // ✅ Bonus 2: Total pages
        Text(
            text = "Total Pages: ${viewModel.totalPages}",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(books) { book ->
                // ✅ هذا باش ما يبقاش BookItem حمراء
                // (يعرض العنوان فقط، وبلا errors)
                Text(
                    text = "${book.title} - ${book.nbPages} pages",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}