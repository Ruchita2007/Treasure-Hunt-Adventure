
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TreasureHuntAdventure extends JFrame {

    private static final int ROWS = 10;
    private static final int COLS = 12;
    private static final int TILE = 52;

    private final String[][] levels = {
        {
            "############",
            "#P..C.....E#",
            "#..#....#..#",
            "#..#..C....#",
            "#..#....#..#",
            "#....#.....#",
            "#.K..#..C..#",
            "#....#.....#",
            "#..^^....T.#",
            "############"
        },
        {
            "############",
            "#P..#.....E#",
            "#...#..C...#",
            "#.C....#...#",
            "###.#..#...#",
            "#...#......#",
            "#.K.#.##...#",
            "#...#...^^.#",
            "#.....T....#",
            "############"
        },
        {
            "############",
            "#P....#...E#",
            "#.##..#....#",
            "#....C.....#",
            "###..#..##.#",
            "#....#.....#",
            "#.K..#..C..#",
            "#....#..^^.#",
            "#..C...T...#",
            "############"
        }
    };

    private char[][] map = new char[ROWS][COLS];
    private int playerRow, playerCol;
    private int level = 0;
    private int score = 0;
    private int lives = 3;

    private boolean hasKey = false;
    private boolean hasTreasure = false;
    private boolean gameOver = false;

    private int hintsUsed = 0;

    private JLabel statusLabel;
    private JLabel messageLabel;
    private JLabel hintLabel;
    private GamePanel gamePanel;

    public TreasureHuntAdventure() {
        setTitle("Treasure Hunt Adventure: The Lost Treasure");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        statusLabel = new JLabel();
        statusLabel.setFont(new Font("Arial", Font.BOLD, 15));
        statusLabel.setBorder(
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        messageLabel = new JLabel("Find the key, treasure, and exit!");
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        hintLabel = new JLabel(
            "Click Get Hint when you need help."
        );
        hintLabel.setFont(new Font("Arial", Font.BOLD, 14));
        hintLabel.setForeground(new Color(30, 100, 180));

        gamePanel = new GamePanel();

        JButton hintButton = new JButton("💡 Get Hint");
        JButton restartButton = new JButton("Restart Game");

        hintButton.setFont(new Font("Arial", Font.BOLD, 14));
        restartButton.setFont(new Font("Arial", Font.BOLD, 14));

        hintButton.addActionListener(e -> giveSmartHint());
        restartButton.addActionListener(e -> restartGame());

        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        topPanel.add(statusLabel);
        topPanel.add(messageLabel);

        JPanel bottomPanel = new JPanel(new GridLayout(2, 1, 5, 5));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(hintButton);
        buttonPanel.add(restartButton);

        bottomPanel.add(buttonPanel);
        bottomPanel.add(hintLabel);

        JPanel mainPanel = new JPanel(new BorderLayout(5, 5));
        mainPanel.setBorder(
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        );
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(gamePanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);

        loadLevel();
        updateStatus();

        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKey(e.getKeyCode());
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        requestFocusInWindow();
    }

    private void loadLevel() {
        hasKey = false;
        hasTreasure = false;

        String[] layout = levels[level];

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                char tile = layout[r].charAt(c);

                if (tile == 'P') {
                    playerRow = r;
                    playerCol = c;
                    map[r][c] = '.';
                } else {
                    map[r][c] = tile;
                }
            }
        }

        gameOver = false;
        hintLabel.setText("💡 Your smart hint will appear here.");
        messageLabel.setText("Level " + (level + 1) +
            ": Find the key, treasure, and exit!");

        updateStatus();
        gamePanel.repaint();
    }

    private void handleKey(int key) {
        if (gameOver) {
            return;
        }

        int r = playerRow;
        int c = playerCol;

        switch (key) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                r--;
                break;

            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                r++;
                break;

            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                c--;
                break;

            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                c++;
                break;

            default:
                return;
        }

        movePlayer(r, c);
    }

    private void movePlayer(int r, int c) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS) {
            return;
        }

        if (map[r][c] == '#') {
            messageLabel.setText("A wall blocks your way!");
            return;
        }

        char tile = map[r][c];

        if (tile == 'E' && !(hasKey && hasTreasure)) {
            messageLabel.setText(
                "The exit is locked! Find the key and treasure first."
            );
            return;
        }

        if (tile == 'T' && !hasKey) {
            messageLabel.setText(
                "You need the key before collecting the treasure!"
            );
            return;
        }

        playerRow = r;
        playerCol = c;

        switch (tile) {
            case 'C':
                score += 10;
                map[r][c] = '.';
                messageLabel.setText("Coin collected! +10 points.");
                break;

            case 'K':
                hasKey = true;
                map[r][c] = '.';
                messageLabel.setText(
                    "You found the key! Now find the treasure."
                );
                break;

            case 'T':
                hasTreasure = true;
                map[r][c] = '.';
                score += 100;
                messageLabel.setText(
                    "Treasure collected! +100 points. Find the exit!"
                );
                break;

            case '^':
                lives--;
                map[r][c] = '.';
                messageLabel.setText(
                    "Trap! You lost one life."
                );

                if (lives <= 0) {
                    finishGame(false);
                    return;
                }
                break;

            case 'E':
                if (hasKey && hasTreasure) {
                    score += 50;

                    if (level < levels.length - 1) {
                        level++;
                        messageLabel.setText(
                            "Level completed! +50 points."
                        );
                        loadLevel();
                    } else {
                        finishGame(true);
                        return;
                    }
                }
                break;

            default:
                messageLabel.setText("Keep exploring!");
        }

        updateStatus();
        gamePanel.repaint();
    }

    // SMART HINT SYSTEM

    private void giveSmartHint() {
        if (gameOver) {
            hintLabel.setText("The game has ended. Restart to play again.");
            return;
        }

        int targetRow = -1;
        int targetCol = -1;
        String targetName;

        // Find the next objective in the correct order.
        if (!hasKey) {
            targetName = "key";
            int[] target = findTile('K');
            targetRow = target[0];
            targetCol = target[1];

        } else if (!hasTreasure) {
            targetName = "treasure";
            int[] target = findTile('T');
            targetRow = target[0];
            targetCol = target[1];

        } else {
            targetName = "exit";
            int[] target = findTile('E');
            targetRow = target[0];
            targetCol = target[1];
        }

        if (targetRow == -1) {
            hintLabel.setText("No target found. Try restarting the level.");
            return;
        }

        String direction = findDirection(
            playerRow, playerCol, targetRow, targetCol
        );

        hintsUsed++;

        hintLabel.setText(
            "<html>💡 Hint #" + hintsUsed + ": " +
            direction + " to find the " + targetName + ".</html>"
        );

        messageLabel.setText(
            "Smart Hint: Follow the direction to your next objective!"
        );
    }

    private int[] findTile(char target) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (map[r][c] == target) {
                    return new int[]{r, c};
                }
            }
        }

        return new int[]{-1, -1};
    }

    // Breadth-first search finds a shortest path to the target.
    private String findDirection(
        int startR, int startC, int targetR, int targetC
    ) {
        int[][] dr = {-1, 1, 0, 0};
        int[][] dc = {0, 0, -1, 1};

        String[] directions = {
            "Move UP", "Move DOWN", "Move LEFT", "Move RIGHT"
        };

        boolean[][] visited = new boolean[ROWS][COLS];
        int[][] firstMove = new int[ROWS][COLS];

        for (int[] row : firstMove) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startR, startC});
        visited[startR][startC] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            if (r == targetR && c == targetC) {
                int move = firstMove[r][c];

                if (move == -1) {
                    return "You are already at the target!";
                }

                return directions[move];
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= ROWS ||
                    nc < 0 || nc >= COLS) {
                    continue;
                }

                if (visited[nr][nc] || map[nr][nc] == '#') {
                    continue;
                }

                // Prefer a safe path when possible.
                if (map[nr][nc] == '^') {
                    continue;
                }

                visited[nr][nc] = true;

                if (r == startR && c == startC) {
                    firstMove[nr][nc] = d;
                } else {
                    firstMove[nr][nc] = firstMove[r][c];
                }

                queue.offer(new int[]{nr, nc});
            }
        }

        // If all safe routes are blocked, allow routes through traps.
        return findDirectionAllowingTraps(
            startR, startC, targetR, targetC
        );
    }

    private String findDirectionAllowingTraps(
        int startR, int startC, int targetR, int targetC
    ) {
        int[][] dr = {-1, 1, 0, 0};
        int[][] dc = {0, 0, -1, 1};

        String[] directions = {
            "Move UP", "Move DOWN", "Move LEFT", "Move RIGHT"
        };

        boolean[][] visited = new boolean[ROWS][COLS];
        int[][] firstMove = new int[ROWS][COLS];

        for (int[] row : firstMove) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startR, startC});
        visited[startR][startC] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            if (r == targetR && c == targetC) {
                int move = firstMove[r][c];

                if (move == -1) {
                    return "You are already at the target!";
                }

                return directions[move] +
                    " (watch out for traps!)";
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= ROWS ||
                    nc < 0 || nc >= COLS) {
                    continue;
                }

                if (visited[nr][nc] || map[nr][nc] == '#') {
                    continue;
                }

                visited[nr][nc] = true;

                if (r == startR && c == startC) {
                    firstMove[nr][nc] = d;
                } else {
                    firstMove[nr][nc] = firstMove[r][c];
                }

                queue.offer(new int[]{nr, nc});
            }
        }

        return "No path found. Explore another route!";
    }

    private void updateStatus() {
        statusLabel.setText(
            "Level: " + (level + 1) + "/" + levels.length +
            "     Score: " + score +
            "     Lives: " + lives +
            "     Key: " + (hasKey ? "Found" : "Missing") +
            "     Treasure: " + (hasTreasure ? "Found" : "Missing") +
            "     Hints: " + hintsUsed
        );
    }

    private void finishGame(boolean won) {
        gameOver = true;
        gamePanel.repaint();

        String title = won ? "You Win!" : "Game Over";
        String text = won
            ? "Congratulations! You found the lost treasure!\n"
                + "Final Score: " + score
            : "You ran out of lives!\nFinal Score: " + score;

        messageLabel.setText(title + " Final Score: " + score);

        JOptionPane.showMessageDialog(
            this, text, title, JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void restartGame() {
        level = 0;
        score = 0;
        lives = 3;
        hintsUsed = 0;
        loadLevel();
        gamePanel.repaint();
        requestFocusInWindow();
    }

    private class GamePanel extends JPanel {

        GamePanel() {
            setPreferredSize(
                new Dimension(COLS * TILE, ROWS * TILE)
            );
            setBackground(Color.BLACK);
            setFocusable(true);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
            );

            for (int r = 0; r < ROWS; r++) {
                for (int c = 0; c < COLS; c++) {
                    int x = c * TILE;
                    int y = r * TILE;

                    char tile = map[r][c];

                    if (tile == '#') {
                        g2.setColor(new Color(55, 60, 75));
                    } else {
                        g2.setColor(new Color(225, 218, 190));
                    }

                    g2.fillRect(x, y, TILE, TILE);

                    g2.setColor(new Color(190, 185, 165));
                    g2.drawRect(x, y, TILE, TILE);

                    String symbol = "";
                    Color color = Color.BLACK;

                    switch (tile) {
                        case 'C':
                            symbol = "$";
                            color = new Color(210, 150, 0);
                            break;
                        case 'K':
                            symbol = "K";
                            color = new Color(30, 100, 210);
                            break;
                        case 'T':
                            symbol = "★";
                            color = new Color(180, 70, 190);
                            break;
                        case '^':
                            symbol = "!";
                            color = Color.RED;
                            break;
                        case 'E':
                            symbol = "E";
                            color = new Color(20, 145, 70);
                            break;
                    }

                    if (!symbol.isEmpty()) {
                        g2.setFont(new Font("Arial", Font.BOLD, 26));
                        g2.setColor(color);
                        FontMetrics fm = g2.getFontMetrics();

                        int tx = x + (TILE - fm.stringWidth(symbol)) / 2;
                        int ty = y + (TILE + fm.getAscent()
                            - fm.getDescent()) / 2;

                        g2.drawString(symbol, tx, ty);
                    }
                }
            }

            // Draw the player.
            int px = playerCol * TILE;
            int py = playerRow * TILE;

            g2.setColor(new Color(30, 110, 220));
            g2.fillOval(px + 7, py + 7, TILE - 14, TILE - 14);

            g2.setColor(Color.WHITE);
            g2.setFont(new Font("Arial", Font.BOLD, 22));
            g2.drawString("@", px + 17, py + 33);

            if (gameOver) {
                g2.setColor(new Color(0, 0, 0, 150));
                g2.fillRect(0, 0, getWidth(), getHeight());

                g2.setColor(Color.WHITE);
                g2.setFont(new Font("Arial", Font.BOLD, 30));
                String text = level == levels.length - 1 &&
                    hasKey && hasTreasure
                    ? "YOU WIN!" : "GAME OVER";

                FontMetrics fm = g2.getFontMetrics();
                g2.drawString(
                    text,
                    (getWidth() - fm.stringWidth(text)) / 2,
                    getHeight() / 2
                );
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TreasureHuntAdventure();
        });
    }
}
