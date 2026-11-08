package com.example.aplikasikopidannyemil.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aplikasikopidannyemil.ui.theme.*

@Composable
fun AddressScreen(navController: NavController) {
    var namaLengkap by remember { mutableStateOf("Raihan Fadhila") }
    var alamat by remember { mutableStateOf("") }
    var patokan by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SoftGreen)
            .padding(24.dp)
    ) {
        // Step Indicator Tagline
        Surface(
            shape = RoundedCornerShape(12.dp),
            color = LightGreen.copy(alpha = 0.2f),
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text(
                text = "LANGKAH 1 DARI 2",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = DarkGreen,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
            )
        }

        Text("Alamat Pengiriman", fontSize = 28.sp, fontWeight = FontWeight.ExtraBold, color = Color.Black)
        Spacer(modifier = Modifier.height(4.dp))
        Text("Masukkan detail lokasi untuk pengantaran pesananmu", fontSize = 14.sp, color = Color.Black)

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = SurfaceWhite),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                OutlinedTextField(
                    value = namaLengkap,
                    onValueChange = { namaLengkap = it },
                    label = { Text("Nama Penerima", color = Color.Black, fontWeight = FontWeight.Medium) },
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
                        focusedContainerColor = SoftGreen.copy(alpha = 0.4f),
                        unfocusedContainerColor = SoftGreen.copy(alpha = 0.4f),
                        focusedBorderColor = DarkGreen,
                        unfocusedBorderColor = InputBorderColor
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(14.dp))

                OutlinedTextField(
                    value = alamat,
                    onValueChange = { alamat = it },
                    label = { Text("Alamat Lengkap (Jalan, RT/RW, Kec)", color = Color.Black, fontWeight = FontWeight.Medium) },
                    leadingIcon = { Icon(Icons.Default.Home, contentDescription = null, tint = Color.Black) },
                    shape = RoundedCornerShape(16.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        focusedLabelColor = Color.Black,
                        unfocusedLabelColor = Color.Black,
                        focusedLeadingIconColor = Color.Black,
                        unfocusedLeadingIconColor = Color.Black,
                        focusedContainerColor = SoftGreen.copy(alpha = 0.4f),
                        unfocusedContainerColor = SoftGreen.copy(alpha = 0.4f),
                        focusedBorderColor = DarkGreen,
                        unfocusedBorderColor = InputBorderColor
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(110.dp)
                )

                Spacer(modifier = Modifier.height(14.dp))

                OutlinedTextField(
                    value = patokan,
                    onValueChange = { patokan = it },
                    label = { Text("Catatan / Patokan", color = Color.Black, fontWeight = FontWeight.Medium) },
                    leadingIcon = { Icon(Icons.Default.LocationOn, contentDescription = null, tint = Color.Black) },
                    shape = RoundedCornerShape(16.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        focusedLabelColor = Color.Black,
                        unfocusedLabelColor = Color.Black,
                        focusedLeadingIconColor = Color.Black,
                        unfocusedLeadingIconColor = Color.Black,
                        focusedContainerColor = SoftGreen.copy(alpha = 0.4f),
                        unfocusedContainerColor = SoftGreen.copy(alpha = 0.4f),
                        focusedBorderColor = DarkGreen,
                        unfocusedBorderColor = InputBorderColor
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { navController.navigate("confirmation") },
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            shape = RoundedCornerShape(18.dp),
            colors = ButtonDefaults.buttonColors(containerColor = DarkGreen),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
        ) {
            Text("Lanjut ke Konfirmasi", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = SurfaceWhite)
        }
    }
}

@Composable
fun ConfirmationScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SoftGreen)
            .padding(28.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Glowing Success Icon Badge
        Box(
            modifier = Modifier
                .size(110.dp)
                .clip(CircleShape)
                .background(LightGreen.copy(alpha = 0.25f)),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .background(DarkGreen),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Success",
                    tint = SurfaceWhite,
                    modifier = Modifier.size(46.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Pesanan Diterima!",
            fontSize = 26.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Terima kasih, Raihan! Pesananmu sedang disiapkan dan kurir kami akan segera mengantarnya.",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = Color.Black,
            lineHeight = 22.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = SurfaceWhite),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Ringkasan Pesanan", fontWeight = FontWeight.Bold, fontSize = 15.sp, color = Color.Black)
                    Surface(shape = RoundedCornerShape(10.dp), color = LightGreen.copy(alpha = 0.2f)) {
                        Text("Dalam Pengantaran 🛵", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = DarkGreen, modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))
                    }
                }
                Spacer(modifier = Modifier.height(14.dp))
                HorizontalDivider(color = InputBorderColor)
                Spacer(modifier = Modifier.height(14.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("1x Kopi Susu Gula Aren", fontSize = 14.sp, color = Color.Black)
                    Text("Rp 20.000", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = DarkGreen)
                }
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = {
                navController.navigate("home") { popUpTo("home") { inclusive = true } }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            shape = RoundedCornerShape(18.dp),
            colors = ButtonDefaults.buttonColors(containerColor = DarkGreen),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
        ) {
            Text("Kembali ke Beranda", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = SurfaceWhite)
        }
    }
}
