package com.uolimzhanov.kattabozortest.ui.screens.offers

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uolimzhanov.kattabozortest.R
import com.uolimzhanov.kattabozortest.ui.theme.KattaBozorTestTheme

val TextRegular = TextStyle(
    fontWeight = FontWeight.Normal,
    platformStyle = PlatformTextStyle(
        includeFontPadding = false
    ),
    lineHeightStyle = LineHeightStyle(
        alignment = LineHeightStyle.Alignment.Center,
        trim = LineHeightStyle.Trim.None
    )
)
val TextBold = TextStyle(
    fontWeight = FontWeight.Bold,
    platformStyle = PlatformTextStyle(
        includeFontPadding = false
    ),
    lineHeightStyle = LineHeightStyle(
        alignment = LineHeightStyle.Alignment.Center,
        trim = LineHeightStyle.Trim.None
    )
)
val TextRegular14_20 = TextRegular.copy(
    fontSize = 14.sp,
    lineHeight = 20.sp,
)
val TextBold14_20 = TextBold.copy(
    fontSize = 14.sp,
    lineHeight = 20.sp,
)


@Composable
fun ReviewText(
    modifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    text: AnnotatedString,
    maxLines: Int = 4,
    showMoreText: String = "... Show More",
    showMoreStyle: SpanStyle = SpanStyle(color = Color.Gray),
    showLessText: String = " Show Less",
    showLessStyle: SpanStyle = showMoreStyle,
    textAlign: TextAlign? = null,
    isExpanded: Boolean = true,
    onExpand: (Boolean) -> Unit = {},
) {
    // State variables to track the expanded state, clickable state, and last character index.
    var clickable by remember { mutableStateOf(false) }
    var lastCharIndex by remember { mutableIntStateOf(0) }

    // Box composable containing the Text composable.
    Box(
        modifier = Modifier
            .clickable(clickable) {
                onExpand(!isExpanded)
            }
            .then(modifier)
    ) {
        // Text composable with buildAnnotatedString to handle "Show More" and "Show Less" buttons.
        Text(
            modifier = textModifier
                .fillMaxWidth()
                .animateContentSize(),
            text = buildAnnotatedString {
                if (clickable) {
                    if (isExpanded) {
                        // Display the full text and "Show Less" button when expanded.
                        append(text)
                        withStyle(style = showLessStyle) { append(showLessText) }
                    } else {
                        // Display truncated text and "Show More" button when collapsed.
                        val adjustText = text.substring(startIndex = 0, endIndex = lastCharIndex)
                            .dropLast(showMoreText.length)
                            .dropLastWhile { Character.isWhitespace(it) || it == '.' }
                            .run {
                                val pros = stringResource(id = R.string.pros)
                                val cons = stringResource(id = R.string.cons)
                                val comment = stringResource(id = R.string.comment)
                                trimIndent()
                                val prosText = substringAfter(pros).substringBefore(cons).trim()
                                val consText = substringAfter(cons).substringBefore(comment).trim()
                                val commentText = substringAfter(comment).trim()
                                reviewText(prosText = prosText, consText = consText, commentText = commentText)
                            }
                        append(adjustText)
                        withStyle(style = showMoreStyle) {
                            append(Typography.ellipsis)
                            append(showMoreText)
                        }
                    }
                } else {
                    // Display the full text when not clickable.
                    append(text)
                }
            },
            // Set max lines based on the expanded state.
            maxLines = if (isExpanded) Int.MAX_VALUE else maxLines,
            // Callback to determine visual overflow and enable click ability.
            onTextLayout = { textLayoutResult ->
                if (!isExpanded && textLayoutResult.hasVisualOverflow) {
                    clickable = true
                    lastCharIndex = textLayoutResult.getLineEnd(maxLines - 1)
                }
            },
            textAlign = textAlign,
        )
    }
}

@Preview
@Composable
fun ReviewTextPreview() {
    val pros = "Zuda ham zoʻr telefon hammaga shuni olishni maslat qilaman maza qilib ishlatasz"
    val cons = "Hammasi joyida"
    val comment = "Olsa boladi"
    KattaBozorTestTheme {
        ReviewText(
            text = reviewText(
                prosText = pros,
                consText = cons,
                commentText = comment
            ),
            modifier = Modifier
                .padding(top = 10.dp, start = 15.dp, end = 15.dp)
                .clickable { },
            isExpanded = false,
            showLessText = "меньше",
            showMoreText = " ещё",
            maxLines = 4
        )
    }
}


@Composable
fun reviewText(
    prosText: String?,
    consText: String?,
    commentText: String?,
    titleStyle: TextStyle = TextBold14_20,
    textStyle: TextStyle = TextRegular14_20
): AnnotatedString {
    return buildAnnotatedString {
        if (!prosText.isNullOrEmpty()) {
            withStyle(
                style = titleStyle.toSpanStyle()
            ) {
                appendLine(stringResource(id = R.string.pros))
            }
            withStyle(
                style = textStyle.toSpanStyle()
            ) {
                appendLine(prosText)
            }
        }
        if (!consText.isNullOrEmpty()) {
            withStyle(
                style = titleStyle.toSpanStyle()
            ) {
                appendLine(stringResource(id = R.string.cons))
            }
            withStyle(
                style = textStyle.toSpanStyle()
            ) {
                appendLine(consText)
            }
        }
        if (!commentText.isNullOrEmpty()) {
            withStyle(
                style = titleStyle.toSpanStyle()
            ) {
                appendLine(stringResource(id = R.string.comment))
            }
            withStyle(
                style = textStyle.toSpanStyle()
            ) {
                append(commentText)
            }
        }
    }
}

@Composable
fun ExpandableText(
    modifier: Modifier = Modifier,
    text: AnnotatedString,
    minimizedMaxLines: Int,
    style: TextStyle
) {
    var expanded by remember { mutableStateOf(false) }
    var hasVisualOverflow by remember { mutableStateOf(false) }
    Box(modifier = modifier) {
        Text(
            text = text,
            maxLines = if (expanded) Int.MAX_VALUE else minimizedMaxLines,
            onTextLayout = { hasVisualOverflow = it.hasVisualOverflow },
            style = style
        )
        if (hasVisualOverflow) {
            Row(
                modifier = Modifier.align(Alignment.BottomEnd),
                verticalAlignment = Alignment.Bottom
            ) {
                val lineHeightDp: Dp = with(LocalDensity.current) { style.lineHeight.toDp() }
                Spacer(
                    modifier = Modifier
                        .width(48.dp)
                        .height(lineHeightDp)
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(Color.Transparent, Color.White)
                            )
                        )
                )
                Text(
                    modifier = Modifier
                        .background(Color.White)
                        .padding(start = 4.dp)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() },
                            onClick = { expanded = !expanded }
                        ),
                    text = "Ещё",
                    color = MaterialTheme.colorScheme.primary,
                    style = style
                )
            }
        }
    }
}