<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Stefano Lagattolla">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,300italic,400,400italic,600,600italic%7CNoto+Serif:400,400italic,700,700italic%7CDroid+Sans+Mono:400,700">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
   <h1>Damas JUnit</h1>
   <div class="info">
    <span id="author" class="author">Stefano Lagattolla</span><br>
    <span id="email" class="email"><a href="mailto:stefanolagattolla.s@gmail.com">stefanolagattolla.s@gmail.com</a></span><br>
    <span id="revnumber">version 0.1.1</span>
   </div>
   <div id="indice">
        <ul>
            <li><a href="#test">Script Tests</a></li>
        </ul>
   </div>
    <div id="test">
        <h5>Controllers</h5>
        <span>ResumeController</span>
        <ul>
            <li><a href="#test">ResumeTest</a></li>
        </ul>
        <span>PlayController</span>
        <ul>
            <li><a href="#test">PlayControllerMoveTest</a></li>
            <li><a href="#test">PlayControllerCancelTest</a></li>
            <li><a href="#test">PlayControllerIsBlocked</a></li>
        </ul>
        <h5>Models</h5>
        <span>GameTest</span>
        <ul>
            <li><a href="#test">testGameReset</a></li>
            <li><a href="#test">testStartGameCorrect</a></li>
            <li><a href="#test">testStartGameCIncorrect</a></li>
            <li><a href="#test">testGameCancel</a></li>
        </ul>
        <span>MoveTest</span>
        <ul>
            <li><a href="#test">correctMoveTwoSpaceDamaTest</a></li>
            <li><a href="#test">correctMoveEatDamaTest</a></li>
            <li><a href="#test">correctMovePawnTest</a></li>
            <li><a href="#test">correctMoveEatPawnTest</a></li>
            <li><a href="#test">incorrectMoveEmptyOrigin</a></li>
            <li><a href="#test">incorrectMoveOppositePiece</a></li>
            <li><a href="#test">incorrectMoveNotEmptyTarget</a></li>
            <li><a href="#test">incorrectMoveTooMuchJumps</a></li>
        </ul>
        <span>PiecesTest</span>
        <ul>
            <li><a href="#test">correctIsAdvanced</a></li>
            <li><a href="#test">incorrectIsAdvanced</a></li>
        </ul>
        <span>DirectionTest</span>
        <ul>
            <li><a href="#test">correctDirectionTest</a></li>
            <li><a href="#test">incorrectDirectionTest</a></li>
        </ul>
        <span>CoordinateTest</span>
        <ul>
            <li><a href="#test">IsWithinTest</a></li>
            <li><a href="#test">getDirectionTest</a></li>
        </ul>
        <h5>Views</h5>
        <span>GameViewTest</span>
        <ul>
            <li><a href="#test">gameResultsTest</a></li>
        </ul>
        <span>PlayViewTest</span>
        <ul>
            <li><a href="#test">playCancelTest</a></li>
            <li><a href="#test">playBadFormatTest</a></li>
            <li><a href="#test">playCorrectMoveTest</a></li>
            <li><a href="#test">playCorrectMoveDoubleTest</a></li>
            <li><a href="#test">playCorrectMoveLostMessage</a></li>
        </ul>
        <span>ResumeViewTest</span>
        <ul>
            <li><a href="#test">resumeResetTest</a></li>
            <li><a href="#test">resumeNextTest</a></li>
        </ul>
    </div>
</body>
</html>