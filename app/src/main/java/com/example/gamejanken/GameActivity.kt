package com.example.gamejanken
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity(){
    private lateinit var computerImageView: ImageView
    private lateinit var rockImageButton: ImageButton
    private lateinit var duajariImageButton: ImageButton
    private lateinit var paperImageButton: ImageButton
    private lateinit var resultImageView: ImageView

    private fun initComponents(){
        computerImageView = findViewById(R.id.computerImageView)
        rockImageButton = findViewById(R.id.rockImageButton)
        duajariImageButton = findViewById(R.id.duajariImageButton)
        paperImageButton = findViewById(R.id.paperImageButton)
        resultImageView = findViewById(R.id.resultImageView)
    }
    private fun initlisteners(){
        rockImageButton.setOnClickListener { startGame("ROCK") }
        duajariImageButton.setOnClickListener { startGame( "DUAJARI") }
        paperImageButton.setOnClickListener { startGame("paper") }

    }

    private fun startGame(option: String) {
        val computerOption = Game.pickRandomOption()
        computerImageView.setImageResource(Game.pickDrawable(computerOption))

        when{
            Game.isDraw(option,computerOption) -> resultImageView.setImageResource(R.drawable.tryagain)
            Game.isWin(option,computerOption) -> resultImageView.setImageResource(R.drawable.horay)
            else -> resultImageView.setImageResource(R.drawable.lose)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game)

        initComponents()
        initlisteners()
    }

}


