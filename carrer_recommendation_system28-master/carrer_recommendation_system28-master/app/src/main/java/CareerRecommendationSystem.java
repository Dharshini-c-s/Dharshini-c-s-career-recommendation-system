public class CareerRecommendation
    private int score = 0;

    public void processAnswer(int optionIndex) {
        score += calculateScore(optionIndex);
    }

    public String getRecommendation() {
        if (score >= 7) {
            return "Scientist or Researcher";
        } else if (score >= 5) {
            return "Engineer or Mathematician";
        } else if (score >= 3) {
            return "Artist or Writer";
        } else {
            return "Social Worker or Communicator";
        }
    }

    private int calculateScore(int optionIndex) {
        switch (optionIndex) {
            case 0:
                return 3;
            case 1:
                return 2;
            case 2:
                return 1;
            case 3:
                return 0;
            default:
                System.out.println("Invalid choice. Assuming neutral response (0 points).");
                return 0;
        }
    }
}