import java.sql.*;
import java.util.regex.Pattern;
import org.mindrot.jbcrypt.BCrypt;

public class OnlineQuizApplication {

    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/quizdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        
        OnlineQuizApplication app = new OnlineQuizApplication();
        app.createUser("user1", "password1", "user1@example.com");
        app.addQuestion(1, "What is 2 + 2?", new String[]{"3", "4", "5"}, "4");
        app.takeQuiz(1);
    }

    
    public boolean authenticateUser(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return false;
        }
    }

    
    public String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    public boolean checkPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }

    
    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&-]+(?:\\.[a-zA-Z0-9_+&-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    
    public void createUser(String username, String password, String email) {
        if (!isValidEmail(email)) {
            System.out.println("Invalid email format.");
            return;
        }
        String hashedPassword = hashPassword(password);
        String query = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setString(2, hashedPassword);
            pstmt.setString(3, email);
            pstmt.executeUpdate();
            System.out.println("User created successfully.");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    
    public void addQuestion(int quizId, String questionText, String[] options, String correctAnswer) {
        String query = "INSERT INTO questions (quiz_id, question_text, options, correct_answer) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, quizId);
            pstmt.setString(2, questionText);
            pstmt.setString(3, String.join(",", options));
            pstmt.setString(4, correctAnswer);
            pstmt.executeUpdate();
            System.out.println("Question added successfully.");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    
    public void takeQuiz(int quizId) {
        String query = "SELECT * FROM questions WHERE quiz_id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, quizId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("question_text"));
                String[] options = rs.getString("options").split(",");
                for (String option : options) {
                    System.out.println(option);
                }
                
                String userAnswer = "4"; 
                if (userAnswer.equals(rs.getString("correct_answer"))) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}