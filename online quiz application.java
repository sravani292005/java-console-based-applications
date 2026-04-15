import java.util.*;

class Question {
    String question;
    String[] options;
    int correctAnswer; // index (0–3)

    Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    void display() {
        System.out.println(question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Question> quiz = new ArrayList<>();

    public static void main(String[] args) {
        loadQuestions();
        startQuiz();
    }

    static void loadQuestions() {
        quiz.add(new Question(
            "What is the capital of India?",
            new String[]{"Mumbai", "Delhi", "Chennai", "Kolkata"},
            1
        ));

        quiz.add(new Question(
            "Which language is used for Android development?",
            new String[]{"Python", "Java", "C++", "HTML"},
            1
        ));

        quiz.add(new Question(
            "Who developed Java?",
            new String[]{"Microsoft", "Apple", "Sun Microsystems", "Google"},
            2
        ));
    }

    static void startQuiz() {
        int score = 0;
        ArrayList<Integer> userAnswers = new ArrayList<>();

        System.out.println("\n--- Online Quiz ---");

        for (int i = 0; i < quiz.size(); i++) {
            Question q = quiz.get(i);
            System.out.println("\nQ" + (i + 1) + ":");
            q.display();

            int ans = getAnswer();
            userAnswers.add(ans);

            if (ans == q.correctAnswer + 1) {
                score++;
            }
        }

        // Result
        System.out.println("\n--- Quiz Completed ---");
        System.out.println("Your Score: " + score + "/" + quiz.size());

        // Correct Answers
        System.out.println("\nCorrect Answers:");
        for (int i = 0; i < quiz.size(); i++) {
            Question q = quiz.get(i);
            System.out.println("Q" + (i + 1) + ": " + q.options[q.correctAnswer]);
        }
    }

    static int getAnswer() {
        while (true) {
            try {
                System.out.print("Enter your answer (1-4): ");
                int ans = Integer.parseInt(sc.nextLine());
                if (ans >= 1 && ans <= 4) return ans;
                else System.out.println("Choose between 1-4!");
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }
        }
    }
}