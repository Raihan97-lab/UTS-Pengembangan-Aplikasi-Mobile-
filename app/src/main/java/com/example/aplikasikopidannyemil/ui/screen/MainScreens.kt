package com.example.aplikasikopidannyemil.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aplikasikopidannyemil.model.dummyMenu
import com.example.aplikasikopidannyemil.ui.theme.*

@Composable
fun HomeScreen(navController: NavController) {
    var selectedCategory by remember { mutableStateOf("Semua") }
    var searchQuery by remember { mutableStateOf("") }
    val categories = listOf("Semua", "☕ Kopi", "🍵 Non-Kopi", "🥐 Camilan")

    Scaffold(
        containerColor = SoftGreen,
        bottomBar = { AppBottomNavigation(navController, currentRoute = "home") }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // User Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("Selamat Datang 👋", fontSize = 13.sp, color = TextMuted)
                    Text("Raihan Fadhila", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                }
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .clip(CircleShape)
                        .background(DarkGreen),
                    contentAlignment = Alignment.Center
                ) {
                    Text("RF", color = SurfaceWhite, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            // Hero Promo Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = DarkGreen),
                elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(18.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = LightGreen,
                            modifier = Modifier.padding(bottom = 6.dp)
                        ) {
                            Text(
                                "PROMO SPESIAL ☕",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = SurfaceWhite,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                        Text("Diskon 20% Hari Ini", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = SurfaceWhite)
                        Text("Gunakan kode: KOPISEGAR", fontSize = 12.sp, color = SurfaceWhite.copy(alpha = 0.8f))
                    }
                    Icon(
                        imageVector = Icons.Default.LocalOffer,
                        contentDescription = null,
                        tint = LightGreen,
                        modifier = Modifier.size(42.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            // Search Bar
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("Cari kopi atau camilan...", color = TextMuted, fontSize = 14.sp) },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = TextMuted) },
                singleLine = true,
                shape = RoundedCornerShape(16.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedLeadingIconColor = Color.Black,
                    unfocusedLeadingIconColor = TextMuted,
                    focusedContainerColor = SurfaceWhite,
                    unfocusedContainerColor = SurfaceWhite,
                    focusedBorderColor = DarkGreen,
                    unfocusedBorderColor = InputBorderColor
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(18.dp))

            // Categories Filter Chips
            LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                items(categories) { category ->
                    val isSelected = category == selectedCategory
                    FilterChip(
                        selected = isSelected,
                        onClick = { selectedCategory = category },
                        label = { Text(category, fontSize = 13.sp, fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal) },
                        shape = RoundedCornerShape(20.dp),
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = DarkGreen,
                            selectedLabelColor = SurfaceWhite,
                            containerColor = SurfaceWhite,
                            labelColor = Color.Black
                        ),
                        border = FilterChipDefaults.filterChipBorder(
                            enabled = true,
                            selected = isSelected,
                            borderColor = InputBorderColor,
                            selectedBorderColor = DarkGreen
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            Text("Menu Spesial Hari Ini", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            Spacer(modifier = Modifier.height(12.dp))

            // Menu List
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 20.dp)
            ) {
                items(dummyMenu) { item ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { navController.navigate("address") },
                        shape = RoundedCornerShape(18.dp),
                        colors = CardDefaults.cardColors(containerColor = SurfaceWhite),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(14.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(68.dp)
                                    .clip(RoundedCornerShape(14.dp))
                                    .background(LightGreen.copy(alpha = 0.15f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = if (item.id <= 3) Icons.Default.Coffee else Icons.Default.Fastfood,
                                    contentDescription = item.name,
                                    tint = DarkGreen,
                                    modifier = Modifier.size(32.dp)
                                )
                            }

                            Spacer(modifier = Modifier.width(14.dp))

                            Column(modifier = Modifier.weight(1f)) {
                                Text(item.name, fontWeight = FontWeight.Bold, fontSize = 15.sp, color = Color.Black)
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(item.description, fontSize = 12.sp, color = TextMuted, maxLines = 1)
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(item.price, fontWeight = FontWeight.Bold, color = DarkGreen, fontSize = 14.sp)
                            }

                            Box(
                                modifier = Modifier
                                    .size(36.dp)
                                    .clip(CircleShape)
                                    .background(DarkGreen),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(Icons.Default.Add, contentDescription = "Tambah", tint = SurfaceWhite, modifier = Modifier.size(20.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileScreen(navController: NavController) {
    var namaInput by remember { mutableStateOf("Raihan Fadhila") }

    Scaffold(
        containerColor = SoftGreen,
        bottomBar = { AppBottomNavigation(navController, currentRoute = "profile") }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(12.dp))

            // Avatar Ring Accent
            Box(
                modifier = Modifier
                    .size(92.dp)
                    .clip(CircleShape)
                    .background(LightGreen.copy(alpha = 0.3f)),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(78.dp)
                        .clip(CircleShape)
                        .background(DarkGreen),
                    contentAlignment = Alignment.Center
                ) {
                    Text("RF", fontSize = 28.sp, fontWeight = FontWeight.ExtraBold, color = SurfaceWhite)
                }
            }

            Spacer(modifier = Modifier.height(14.dp))
            // Full Name Title (Black text)
            Text("Raihan Fadhila", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            Text("NIM: 1247050108", fontSize = 13.sp, color = TextMuted)

            Spacer(modifier = Modifier.height(22.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = SurfaceWhite),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text("Informasi Pengguna", fontWeight = FontWeight.Bold, fontSize = 15.sp, color = Color.Black)
                    Spacer(modifier = Modifier.height(14.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Email, contentDescription = null, tint = DarkGreen, modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(10.dp))
                        Text("Email: raihan@student.uin.ac.id", fontSize = 13.sp, color = TextMuted)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.School, contentDescription = null, tint = DarkGreen, modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(10.dp))
                        Text("Kelas: Teknik Informatika C", fontSize = 13.sp, color = TextMuted)
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Full Name Input Section (Black Text)
            OutlinedTextField(
                value = namaInput,
                onValueChange = { namaInput = it },
                label = { Text("Nama Lengkap", color = Color.Black, fontWeight = FontWeight.Medium) },
                leadingIcon = { Icon(Icons.Default.Person, contentDescription = null, tint = Color.Black) },
                singleLine = true,
                shape = RoundedCornerShape(16.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.Black,
                    focusedLeadingIconColor = Color.Black,
                    unfocusedLeadingIconColor = Color.Black,
                    focusedContainerColor = SurfaceWhite,
                    unfocusedContainerColor = SurfaceWhite,
                    focusedBorderColor = DarkGreen,
                    unfocusedBorderColor = InputBorderColor
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { /* Simpan */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = DarkGreen),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 2.dp)
            ) {
                Text("Simpan Perubahan", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = SurfaceWhite)
            }

            Spacer(modifier = Modifier.weight(1f))

            OutlinedButton(
                onClick = { navController.navigate("welcome") { popUpTo(0) } },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFD32F2F)),
                border = BorderStroke(1.dp, Color(0xFFD32F2F))
            ) {
                Text("Keluar Akun", fontSize = 15.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun AppBottomNavigation(navController: NavController, currentRoute: String) {
    NavigationBar(
        containerColor = SurfaceWhite,
        tonalElevation = 8.dp
    ) {
        NavigationBarItem(
            selected = currentRoute == "home",
            onClick = { if (currentRoute != "home") navController.navigate("home") },
            label = { Text("Menu", fontWeight = if (currentRoute == "home") FontWeight.Bold else FontWeight.Normal) },
            icon = { Icon(Icons.Default.Home, contentDescription = "Menu") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = DarkGreen,
                selectedTextColor = DarkGreen,
                indicatorColor = LightGreen.copy(alpha = 0.25f),
                unselectedIconColor = TextMuted,
                unselectedTextColor = TextMuted
            )
        )
        NavigationBarItem(
            selected = currentRoute == "address",
            onClick = { if (currentRoute != "address") navController.navigate("address") },
            label = { Text("Pesanan", fontWeight = if (currentRoute == "address") FontWeight.Bold else FontWeight.Normal) },
            icon = { Icon(Icons.Default.ShoppingBag, contentDescription = "Pesanan") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = DarkGreen,
                selectedTextColor = DarkGreen,
                indicatorColor = LightGreen.copy(alpha = 0.25f),
                unselectedIconColor = TextMuted,
                unselectedTextColor = TextMuted
            )
        )
        NavigationBarItem(
            selected = currentRoute == "profile",
            onClick = { if (currentRoute != "profile") navController.navigate("profile") },
            label = { Text("Profil", fontWeight = if (currentRoute == "profile") FontWeight.Bold else FontWeight.Normal) },
            icon = { Icon(Icons.Default.Person, contentDescription = "Profil") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = DarkGreen,
                selectedTextColor = DarkGreen,
                indicatorColor = LightGreen.copy(alpha = 0.25f),
                unselectedIconColor = TextMuted,
                unselectedTextColor = TextMuted
            )
        )
    }
}
