package com.example.projectedulab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File
import java.io.FileOutputStream
import android.content.Intent
import androidx.core.content.FileProvider

class TemplateActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_template)

        recyclerView = findViewById(R.id.rvTemplates)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val templates = listOf(
            Template("Template Resume", "18 Pages", R.drawable.cover_TemplateResume, "template_Resume.docx"),
            Template("Template Laporan Praktikum", "28 Pages", R.drawable.cover_TemplateLaporan, "template_jaringan.docx")
        )



        recyclerView.adapter = TemplateAdapter(templates) { template ->
            openWordTemplate(template.fileName)
        }
    }

    // ==========================================
    // Fungsi membuka template Word (.docx)
    // ==========================================
    private fun openWordTemplate(fileName: String) {
        try {
            val input = assets.open(fileName)
            val outFile = File(cacheDir, fileName)
            val output = FileOutputStream(outFile)

            input.copyTo(output)
            input.close()
            output.close()

            val uri = FileProvider.getUriForFile(
                this,
                packageName + ".provider",
                outFile
            )

            val intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(
                uri,
                "application/vnd.openxmlformats-officedocument.wordprocessingml.document"
            )
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)

            startActivity(intent)

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
