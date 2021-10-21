package com.raywenderlich.android.puppycounter.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.raywenderlich.android.puppycounter.R
import com.raywenderlich.android.puppycounter.model.DogCount
import timber.log.Timber

/*
 * Copyright (c) 2021 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or
 * sell copies of the Software, and to permit persons to whom
 * the Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify,
 * merge, publish, distribute, sublicense, create a derivative work,
 * and/or sell copies of the Software in any work that is designed,
 * intended, or marketed for pedagogical or instructional purposes
 * related to programming, coding, application development, or
 * information technology. Permission for such use, copying,
 * modification, merger, publication, distribution, sublicensing,
 * creation of derivative works, or sale is expressly withheld.
 *
 * This project and source code may use libraries or frameworks
 * that are released under various Open-Source licenses. Use of
 * those libraries and frameworks are governed by their own
 * individual licenses.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

class ShareActivity : AppCompatActivity() {

  companion object {

    const val EXTRA_DOG_COUNT = "extra_dog_count"

    fun createIntent(context: Context) = Intent(context, ShareActivity::class.java)
  }

  private lateinit var smallDogStatsLabel: TextView
  private lateinit var middleDogStatsLabel: TextView
  private lateinit var bigDogStatsLabel: TextView

  private var dogCount: DogCount = DogCount()

  override fun onStart() {
    Timber.i("PuppyCounter - ShareActivity - onStart()")
    super.onStart()
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    Timber.i("PuppyCounter - ShareActivity - onCreate()")
    super.onCreate(savedInstanceState)
    setContentView(R.layout.layout_share)
    findViews()
    setOnShareBtnClickListener()
  }

  override fun onResume() {
    Timber.i("PuppyCounter - ShareActivity - onResume()")
    super.onResume()
    renderDogCount(dogCount)
  }

  override fun onPause() {
    Timber.i("PuppyCounter - ShareActivity - onPause()")
    super.onPause()
  }

  override fun onStop() {
    Timber.i("PuppyCounter - ShareActivity - onStop()")
    super.onStop()
  }

  override fun onDestroy() {
    Timber.i("PuppyCounter - ShareActivity - onDestroy()")
    super.onDestroy()
  }

  private fun findViews() {
    smallDogStatsLabel = findViewById(R.id.smallDogStats)
    middleDogStatsLabel = findViewById(R.id.middleDogStats)
    bigDogStatsLabel = findViewById(R.id.bigDogStats)
  }

  private fun setOnShareBtnClickListener() {
    findViewById<Button>(R.id.shareBtn).setOnClickListener {
      openShareDialog()
    }
  }

  private fun renderDogCount(dogCount: DogCount) = with(dogCount) {
    smallDogStatsLabel.text = getString(R.string.small_dog_stats, smallDogCount.toString())
    middleDogStatsLabel.text = getString(R.string.middle_dog_stats, middleDogCount.toString())
    bigDogStatsLabel.text = getString(R.string.big_dog_stats, bigDogCount.toString())
  }

  private fun openShareDialog() {
    AlertDialog.Builder(this)
        .setTitle(R.string.share_dialog_title)
        .setPositiveButton(R.string.share_dialog_yes) { dialog, _ ->
          dialog.dismiss()
          Toast.makeText(this, R.string.puppies_happy, Toast.LENGTH_SHORT).show()
        }
        .setNegativeButton(R.string.share_dialog_no) { dialog, _ ->
          dialog.dismiss()
          Toast.makeText(this, R.string.puppies_sad, Toast.LENGTH_SHORT).show()
        }
        .show()
  }
}