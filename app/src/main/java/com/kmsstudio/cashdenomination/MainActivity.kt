package com.kmsstudio.cashdenomination

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import com.ibm.icu.text.RuleBasedNumberFormat
import com.kmsstudio.cashdenomination.databinding.ActivityMainBinding
import java.text.DecimalFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.editText2000.doAfterTextChanged {
            cal2000()
            total()
            binding.out2000.text = DecimalFormat("##,##,##0").format(cal2000())
        }
        binding.editText500.doAfterTextChanged {
            cal500()
            total()
            binding.out500.text = DecimalFormat("##,##,##0").format(cal500())
        }
        binding.editText200.doAfterTextChanged {
            cal200()
            total()
            binding.out200.text = DecimalFormat("##,##,##0").format(cal200())
        }
        binding.editText100.doAfterTextChanged {
            cal100()
            total()
            binding.out100.text = DecimalFormat("##,##,##0").format(cal100())
        }
        binding.editText50.doAfterTextChanged {
            cal50()
            total()
            binding.out50.text = DecimalFormat("##,##,##0").format(cal50())
        }
        binding.editText20.doAfterTextChanged {
            cal20()
            total()
            binding.out20.text = DecimalFormat("##,##,##0").format(cal20())
        }
        binding.editText10.doAfterTextChanged {
            cal10()
            total()
            binding.out10.text = DecimalFormat("##,##,##0").format(cal10())
        }
        binding.editText5.doAfterTextChanged {
            cal5()
            total()
            binding.out5.text = DecimalFormat("##,##,##0").format(cal5())
        }
        binding.editText2.doAfterTextChanged {
            cal2()
            total()
            binding.out2.text = DecimalFormat("##,##,##0").format(cal2())
        }
        binding.editText1.doAfterTextChanged {
            cal1()
            total()
            binding.out1.text = DecimalFormat("##,##,##0").format(cal1())
        }

    }

    private fun total() {
        val value2000 = cal2000()
        val value500 = cal500()
        val value200 = cal200()
        val value100 = cal100()
        val value50 = cal50()
        val value20 = cal20()
        val value10 = cal10()
        val value5 = cal5()
        val value2 = cal2()
        val value1 = cal1()

        val totalAmount =
            value2000 + value500 + value200 + value100 + value50 + value20 + value10 + value5 + value2 + value1

        val result = DecimalFormat("##,##,##0").format(totalAmount)
        binding.totalAmount.text = result


        binding.valueText.text = convertIntoWords(totalAmount, "en", "in")
    }

    private fun cal2000(): Int {
        val billCount = binding.editText2000.text.toString()
        val billCount2000 = billCount.toIntOrNull() ?: return 0

        val result2000 = 2000 * billCount2000
        binding.out2000.text = DecimalFormat("##,##,##0").format(result2000)

        return result2000

    }

    private fun cal500(): Int {
        val amount500 = 500
        val billCount = binding.editText500.text.toString()
        val billCount500 = billCount.toIntOrNull() ?: return 0


        val result500 = amount500 * billCount500
        binding.out500.text = DecimalFormat("##,##,##0").format(result500)

        return result500

    }

    private fun cal200(): Int {
        val amount200 = 200
        val billCount = binding.editText200.text.toString()
        val billCount200 = billCount.toIntOrNull() ?: return 0


        val result200 = amount200 * billCount200
        binding.out200.text = DecimalFormat("##,##,##0").format(result200)
        return result200

    }

    private fun cal100(): Int {
        val amount100 = 100
        val billCount = binding.editText100.text.toString()
        val billCount100 = billCount.toIntOrNull() ?: return 0


        val result100 = amount100 * billCount100
        binding.out100.text = DecimalFormat("##,##,##0").format(result100)

        return result100

    }

    private fun cal50(): Int {
        val amount50 = 50
        val billCount = binding.editText50.text.toString()
        val billCount50 = billCount.toIntOrNull() ?: return 0


        val result50 = amount50 * billCount50
        binding.out50.text = DecimalFormat("##,##,##0").format(result50)

        return result50
    }

    private fun cal20(): Int {
        val amount20 = 20
        val billCount = binding.editText20.text.toString()
        val billCount20 = billCount.toIntOrNull() ?: return 0


        val result20 = amount20 * billCount20
        binding.out20.text = DecimalFormat("##,##,##0").format(result20)

        return result20
    }

    private fun cal10(): Int {
        val amount10 = 10
        val billCount = binding.editText10.text.toString()
        val billCount10 = billCount.toIntOrNull() ?: return 0


        val result10 = amount10 * billCount10
        binding.out10.text = DecimalFormat("##,##,##0").format(result10)

        return result10
    }

    private fun cal5(): Int {
        val amount5 = 5
        val billCount = binding.editText5.text.toString()
        val billCount5 = billCount.toIntOrNull() ?: return 0


        val result5 = amount5 * billCount5
        binding.out5.text = DecimalFormat("##,##,##0").format(result5)

        return result5
    }

    private fun cal2(): Int {
        val amount2 = 2
        val billCount = binding.editText2.text.toString()
        val billCount2 = billCount.toIntOrNull() ?: return 0


        val result2 = amount2 * billCount2
        binding.out2.text = DecimalFormat("##,##,##0").format(result2)

        return result2

    }

    private fun cal1(): Int {
        val amount1 = 1
        val billCount = binding.editText1.text.toString()
        val billCount1 = billCount.toIntOrNull() ?: return 0


        val result1 = amount1 * billCount1
        binding.out1.text = DecimalFormat("##,##,##0").format(result1)

        return result1

    }

    private fun convertIntoWords(str: Int, language: String, Country: String): String? {
        val local = Locale(language, Country)
        val ruleBasedNumberFormat = RuleBasedNumberFormat(local, RuleBasedNumberFormat.SPELLOUT)
        return ruleBasedNumberFormat.format(str)
    }
}