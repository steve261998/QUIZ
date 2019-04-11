<html>
	<head>
		<title>Online quiz</title>
<!--		<link type='text/css' rel='stylesheet' href='stylesheet.css'/>-->
		<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Open Sans"/>
                <style>
                    body {
    font-family: Open Sans;
}

h1 {
    text-align: center;
}

#title {
    /*text-decoration: underline;*/
    border-bottom:1px solid black;
}

#quiz {
    text-indent: 10px;
    display:none;
}

.button {
    border:4px solid;
    border-radius:5px;
    width: 40px;
    padding-left:5px;
    padding-right: 5px;
    position: relative;
    float:right;
    background-color: #DCDCDC;
    color: black;
    margin: 0 2px 0 2px;
}

.button.active {
    background-color: #F8F8FF;
    color: #525252;
}

button {
    position: relative;
    float:right;
}

.button a {
    text-decoration: none;
    color: black;
}

#container {
    width:100%;
    margin:auto;
    padding: 0 25px 40px 10px;
    background-color: white;
    border:4px solid #B0E0E6;
    border-radius:5px;
    color: black;
    font-weight: bold;
    box-shadow: 5px 5px 5px #888;
}

ul {
    list-style-type: none;
    padding: 0;
    margin: 0;
}

#prev {
    display:none;
}

#start {
    display:none;
    width: 90px;
}
#level{
    
    display:none;
    width: 90px;


}
                </style>
	</head>
	<body>
		<div id='container'>
			<div id='title'>
				<h1>Quiz</h1>
			</div>
   			<br/>
  			<div id='quiz'></div>
    		<div class='button' id='next'><a href='#'>Next</a></div>
    		<div class='button' id='prev'><a href='#'>Prev</a></div>
    		<div class='button' id='start'> <a href='#'>Start Over</a></div>
                <div class='button' id='home'><a href='index.jsp'>Home</a></div>
    		<!-- <button class='' id='next'>Next</a></button>
    		<button class='' id='prev'>Prev</a></button>
    		<button class='' id='start'> Start Over</a></button> -->
    	</div>

		<script type='text/javascript' src='https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js'></script>
		<script type="text/javascript" src='questions.json'></script>
                <script>
                    (function() {
  var questions = [{
    question: "Which of the following devices is operated in physical layer?",
    choices: ["Bridge","Router","Repeater","All of the above"],
    correctAnswer: 0
  }, {
    question: "Which one is the secondary memory device?",
    choices: ["CPU","ALU","Floppy Disk","Mouse"],
    correctAnswer: 2
  }, {
    question: "The place where data or program goes is known as",
    choices: ["Keyboard","CPU","CU","Mouse"],
    correctAnswer: 1
  }, {
    question: "What is 8*8?",
    choices: [20, 30, 40, 50, 64],
    correctAnswer: 4
  }];
  $('#home').hide();
  var questionCounter = 0; //Tracks question number
  var selections = []; //Array containing user choices
  var quiz = $('#quiz'); //Quiz div object
  
  // Display initial question
  displayNext();
  
  // Click handler for the 'next' button
  $('#next').on('click', function (e) {
    e.preventDefault();
    
    // Suspend click listener during fade animation
    if(quiz.is(':animated')) {        
      return false;
    }
    choose();
    
    // If no user selection, progress is stopped
    if (isNaN(selections[questionCounter])) {
      alert('Please make a selection!');
    } else {
      questionCounter++;
      displayNext();
    }
  });
  
  // Click handler for the 'prev' button
  $('#prev').on('click', function (e) {
    e.preventDefault();
    
    if(quiz.is(':animated')) {
      return false;
    }
    choose();
    questionCounter--;
    displayNext();
  });
  
  // Click handler for the 'Start Over' button
  $('#start').on('click', function (e) {
    e.preventDefault();
    
    if(quiz.is(':animated')) {
      return false;
    }
    questionCounter = 0;
    selections = [];
    displayNext();
    $('#start').hide();
  });
  
  // Animates buttons on hover
  $('.button').on('mouseenter', function () {
    $(this).addClass('active');
  });
  $('.button').on('mouseleave', function () {
    $(this).removeClass('active');
  });
  
  // Creates and returns the div that contains the questions and 
  // the answer selections
  function createQuestionElement(index) {
    var qElement = $('<div>', {
      id: 'question'
    });
    
    var header = $('<h2>Question ' + (index + 1) + ':</h2>');
    qElement.append(header);
    
    var question = $('<p>').append(questions[index].question);
    qElement.append(question);
    
    var radioButtons = createRadios(index);
    qElement.append(radioButtons);
    
    return qElement;
  }
  
  // Creates a list of the answer choices as radio inputs
  function createRadios(index) {
    var radioList = $('<ul>');
    var item;
    var input = '';
    for (var i = 0; i < questions[index].choices.length; i++) {
      item = $('<li>');
      input = '<input type="radio" name="answer" value=' + i + ' />';
      input += questions[index].choices[i];
      item.append(input);
      radioList.append(item);
    }
    return radioList;
  }
  
  // Reads the user selection and pushes the value to an array
  function choose() {
    selections[questionCounter] = +$('input[name="answer"]:checked').val();
  }
  
  // Displays next requested element
  function displayNext() {
    quiz.fadeOut(function() {
      $('#question').remove();
      
      if(questionCounter < questions.length){
        var nextQuestion = createQuestionElement(questionCounter);
        quiz.append(nextQuestion).fadeIn();
        if (!(isNaN(selections[questionCounter]))) {
          $('input[value='+selections[questionCounter]+']').prop('checked', true);
        }
        
        // Controls display of 'prev' button
        if(questionCounter === 1){
          $('#prev').show();
        } else if(questionCounter === 0){
          
          $('#prev').hide();
          $('#next').show();
        }
      }else {
        var scoreElem = displayScore();
        quiz.append(scoreElem).fadeIn();
        $('#next').hide();
        $('#prev').hide();
        
       $('#home').show();
        
      }
    });
  }
 var numCorrect =0;
  // Computes score and returns a paragraph element to be displayed
  function displayScore() {
    var score = $('<p>',{id: 'question'});
    
//    var numCorrect = 0;
    for (var i = 0; i < selections.length; i++) {
      if (selections[i] === questions[i].correctAnswer) {
        numCorrect++;
      }
    }
    
    score.append('You got ' + numCorrect + ' questions out of ' +
                 questions.length + ' right!!! You have finished the quiz');
    return score;
  }
})();
                </script>
	</body>
</html>
