package com.hpandro.composeprofileui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ProfilePageCons() {
    Card(
        elevation = 8.dp,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        BoxWithConstraints() {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                val (profileImg, titleTxt, descTxt, statsRow, followBtn, msgBtn) = createRefs()
                val topStartGL = createGuidelineFromTop(0.05f)
                val topEndGL = createGuidelineFromTop(0.95f)
                val centerVerticalGL = createGuidelineFromStart(0.5f)

                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "profile logo",
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .border(width = 2.dp, color = Color.Black, shape = CircleShape)
                        .constrainAs(profileImg) {
                            top.linkTo(topStartGL)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        },
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "Cypress", fontSize = 24.sp, fontWeight = FontWeight.Bold,
                    modifier = Modifier.constrainAs(titleTxt) {
                        top.linkTo(profileImg.bottom, margin = 16.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                )
                Text(text = "Mobile App Development",
                    modifier = Modifier.constrainAs(descTxt) {
                        top.linkTo(titleTxt.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    })

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .constrainAs(statsRow) {
                            top.linkTo(descTxt.bottom, margin = 16.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        },
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ProfileStatsCons("100", "Followers")
                    ProfileStatsCons("120", "Followings")
                    ProfileStatsCons("10", "Posts")
                }

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.constrainAs(followBtn) {
                        top.linkTo(statsRow.bottom, margin = 16.dp)
                        start.linkTo(parent.start)
                        end.linkTo(centerVerticalGL)
                        bottom.linkTo(topEndGL)
                    }) {
                    Text(text = "Follow User")
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.constrainAs(msgBtn) {
                        top.linkTo(statsRow.bottom, margin = 16.dp)
                        start.linkTo(centerVerticalGL)
                        end.linkTo(parent.end)
                        bottom.linkTo(topEndGL)
                    }) {
                    Text(text = "Direct Message")
                }
            }
        }
    }
}

@Composable
private fun ProfileStatsCons(count: String, title: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = count, fontWeight = FontWeight.Bold)
        Text(text = title)
    }
}