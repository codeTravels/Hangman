package com.mycompany.hangman.cmd_line;

import com.mycompany.hangman.model.HangmanGame;
import com.mycompany.hangman.model.Word;
import com.mycompany.hangman.model.WordGeneratorService;

import java.util.Arrays;
import java.util.List;

public class AppRunner {
    int wrongs;
    HangmanGame game;

    public AppRunner() {
        WordGeneratorService wordGeneratorService = () -> new Word("raw");
        game = new HangmanGame(wordGeneratorService);
        game.addPropertyChangeListener(evt -> {
            System.out.println(evt.getPropertyName() + ": " + evt.getNewValue());
            if (evt.getPropertyName().contentEquals(HangmanGame.WRONG_GUESS)) {
                wrongs++;
                drawFigure(wrongs);
            }
        });
    }

    public static void main(String[] args) {
        new AppRunner().doWin();
        new AppRunner().doLose();
    }

    private void doWin() {
        doGuess(game, 'r');
        doGuess(game, 'a');
        doGuess(game, 'w');
    }

    private void doLose() {
        doGuess(game, 'q');
        doGuess(game, 'e');
        doGuess(game, 't');
        doGuess(game, 'y');
        doGuess(game, 'u');
        doGuess(game, 'i');
    }

    private void doGuess(HangmanGame game, char guessChar) {
        System.out.println("guessing: " + guessChar);
        game.processLetter(guessChar);
    }

    void drawFigure(int wrongs) {
        List<FigureState.Limb> limbsToShow = new FigureState().getLimbsToShow(wrongs);
        Character head = limbsToShow.contains(FigureState.Limb.HEAD) ? 'O' : ' ';
        Character trunkUpper = limbsToShow.contains(FigureState.Limb.TRUNK) ? '|' : ' ';
        Character leftArm = limbsToShow.contains(FigureState.Limb.LEFT_ARM) ? '\\' : ' ';
        Character rightArm = limbsToShow.contains(FigureState.Limb.RIGHT_ARM) ? '/' : ' ';
        Character trunkLower = limbsToShow.contains(FigureState.Limb.TRUNK) ? '|' : ' ';
        Character leftLeg = limbsToShow.contains(FigureState.Limb.LEFT_LEG) ? '/' : ' ';
        Character rightLeg = limbsToShow.contains(FigureState.Limb.RIGHT_LEG) ? '\\' : ' ';
        String ascii =
                "    _____\n" +
                        "    |   |\n" +
                        "    " + head + "   |\n" +
                        "   " + leftArm + "" + trunkUpper + "" + rightArm + "  |\n" +
                        "    " + trunkLower + "   |\n" +
                        "   " + leftLeg + " " + rightLeg + "  |\n" +
                        "     _______";
        System.out.println(ascii);
    }

    static class FigureState {
        List<Limb> getLimbsToShow(int wrongs) {
            return Arrays.asList(Limb.values()).subList(0, wrongs);
        }

        enum Limb {
            HEAD,
            TRUNK,
            LEFT_ARM,
            RIGHT_ARM,
            LEFT_LEG,
            RIGHT_LEG
        }
    }

//    -----
//    |   |
//    O   |
//   \|/  |
//    |   |
//   / \  |
//    ________
}
