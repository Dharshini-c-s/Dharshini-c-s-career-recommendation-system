package easy.tuto.carrerrecommendationsystem;
import easy.tuto.carrerrecommendationsystem.CareerRecommendationSystem;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {

    private TextView questionTextView;
    private RadioGroup answerRadioGroup;
    private RadioButton optionARadioButton, optionBRadioButton, optionCRadioButton, optionDRadioButton;
    private Button nextButton;

    private CareerRecommendationSystem careerRecommendationSystem;
    private int currentQuestionIndex = 0;
    private String[] questions; // Array to hold the questions

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.questionTextView);
        answerRadioGroup = findViewById(R.id.answerRadioGroup);
        optionARadioButton = findViewById(R.id.optionARadioButton);
        optionBRadioButton = findViewById(R.id.optionBRadioButton);
        optionCRadioButton = findViewById(R.id.optionCRadioButton);
        optionDRadioButton = findViewById(R.id.optionDRadioButton);
        nextButton = findViewById(R.id.nextButton);

        careerRecommendationSystem = new CareerRecommendationSystem();
        questions = getResources().getStringArray(R.array.questions);

        showQuestion();

        nextButton.setOnClickListener(v -> {
            int selectedOption = getSelectedOption();
            careerRecommendationSystem.processAnswer(selectedOption);

            if (currentQuestionIndex < questions.length - 1) {
                currentQuestionIndex++;
                showQuestion();
            } else {
                showRecommendation();
            }
        });
    }

    private void showQuestion() {
        questionTextView.setText(questions[currentQuestionIndex]);
        answerRadioGroup.clearCheck();
    }

    private int getSelectedOption() {
        int selectedOption = -1;
        if (optionARadioButton.isChecked()) {
            selectedOption = 0;
        } else if (optionBRadioButton.isChecked()) {
            selectedOption = 1;
        } else if (optionCRadioButton.isChecked()) {
            selectedOption = 2;
        } else if (optionDRadioButton.isChecked()) {
            selectedOption = 3;
        }
        return selectedOption;
    }

    private void showRecommendation() {
        String recommendation = careerRecommendationSystem.getRecommendation();
        // Display the recommendation (e.g., in a dialog or a new activity)
    }
}