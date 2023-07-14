<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Currency Converter</title>
<style>
body {
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
	margin: 0;
	padding: 0;
}

header {
	padding: 20px;
	background-color: whitesmoke;
	text-align: center;
}

main {
	max-width: 400px;
	margin: 20px auto;
	padding: 20px;
	background-color: #fff;
	border: 1px solid #ccc;
	border-radius: 5px;
}

h1 {
	margin-top: 0;
}

form {
	margin-bottom: 20px;
}

label {
	display: block;
	margin-bottom: 5px;
}

select, input[type="number"], button {
	width: 100%;
	padding: 10px;
	margin-bottom: 10px;
	font-size: 16px;
	border: transparent;
	border-radius: 5px;
}

input[type="number"] {
	width: 95%;
}

select {
	background-color: #FFCDBE;
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
}

button {
	background-color: #1CADB5;
	color: #fff;
	cursor: pointer;
	border: transparent;
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
}

#resultContainer {
	border-top: 1px solid #ccc;
	padding-top: 20px;
}

#result {
	font-weight: bold;
	margin-bottom: 10px;
}

#rate {
	font-style: italic;
	color: #888;
}

header img {
	width: 150px;
	height: auto;
	display: block;
	margin: 0 auto;
}
</style>
</head>
<body>
	<header>
		<img src="images/logo.png" alt="Logo">
	</header>
	<main>
		<h1>Currency Converter</h1>
		<form id="currencyForm" action="">
			<label for="amount">Amount:</label> <input type="number" id="amount"
				name="amount" required> <label for="fromCurrency">From:</label>
			<select id="fromCurrency" name="fromCurrency" required>
			</select> <label for="toCurrency">To:</label> <select id="toCurrency"
				name="toCurrency" required>
			</select>

			<button type="submit">Convert</button>
			<button type="reset" id="resetButton">Reset</button>
		</form>

		<div id="resultContainer">
			<p id="result"></p>
			<p id="rate"></p>
		</div>
	</main>

<script>
    function fetchCurrencyOptions() {
        // Fetch currency options from API and populate the select elements
        var currencySelects = document.querySelectorAll("select");
        var xhrOptions = new XMLHttpRequest();
        xhrOptions.onreadystatechange = function() {
            if (xhrOptions.readyState === XMLHttpRequest.DONE) {
                if (xhrOptions.status === 200) {
                    var response = JSON.parse(xhrOptions.responseText);
                    if (response.result === "success") {
                        var conversionRates = response.conversion_rates;
                        for (var currency in conversionRates) {
                            if (conversionRates.hasOwnProperty(currency)) {
                                for (var i = 0; i < currencySelects.length; i++) {
                                    var option = document.createElement("option");
                                    option.value = currency;
                                    option.textContent = currency + " - " + conversionRates[currency];
                                    currencySelects[i].appendChild(option);
                                }
                            }
                        }
                    } else {
                        console.log("Error fetching currency options");
                    }
                } else {
                    console.log("Error fetching currency options");
                }
            }
        };

        xhrOptions.open("GET", "https://v6.exchangerate-api.com/v6/0d950d2038943b4df4f1da80/latest/ILS", true);
        xhrOptions.send();
    }

    function fetchCurrencyOptionsFromServlet() {
    	  var currencySelects = document.querySelectorAll("select");

    	  var xhrOptions = new XMLHttpRequest();
    	  xhrOptions.onreadystatechange = function() {
    	    if (xhrOptions.readyState === XMLHttpRequest.DONE) {
    	      if (xhrOptions.status === 200) {
    	        var options = xhrOptions.responseText;
    	        for (var i = 0; i < currencySelects.length; i++) {
    	          currencySelects[i].innerHTML = options;
    	        }
    	      } else {
    	        console.log("Error fetching currency options from server");
    	      }
    	    }
    	  };

    	  xhrOptions.open("POST", "FetchCurrencyOptionsServlet", true);
    	  xhrOptions.send();
    	}


    document.addEventListener("DOMContentLoaded", function() {
        var formSource = new URLSearchParams(window.location.search).get('source');
        if (formSource === 'api') {
            fetchCurrencyOptions();
        } else {
            fetchCurrencyOptionsFromDatabase();
        }

        document.getElementById("currencyForm").addEventListener("submit", function(event) {
            event.preventDefault(); // Prevent form submission

            var amount = document.getElementById("amount").value;
            var fromCurrency = document.getElementById("fromCurrency").value;
            var toCurrency = document.getElementById("toCurrency").value;

            // Make AJAX request to fetch currency conversion rate
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function() {
                if (xhr.readyState === XMLHttpRequest.DONE) {
                    if (xhr.status === 200) {
                        var response = JSON.parse(xhr.responseText);
                        if (response.result === "success") {
                            var rate = response.conversion_rates[toCurrency];
                            var result = parseFloat(amount) * rate;
                            document.getElementById("result").textContent = result.toFixed(2) + " " + toCurrency;
                            document.getElementById("rate").textContent = "Exchange Rate: 1 " + fromCurrency + " = " + rate.toFixed(2) + " " + toCurrency;
                        } else {
                            document.getElementById("result").textContent = "Error fetching conversion rate";
                        }
                    } else {
                        document.getElementById("result").textContent = "Error fetching conversion rate";
                    }
                }
            };

            xhr.open("GET", "https://v6.exchangerate-api.com/v6/0d950d2038943b4df4f1da80/latest/" + fromCurrency, true);
            xhr.send();
        });

        document.getElementById("resetButton").addEventListener("click", function(event) {
            document.getElementById("currencyForm").reset(); // Reset form inputs
            document.getElementById("result").textContent = ""; // Clear result
            document.getElementById("rate").textContent = ""; // Clear exchange rate
        });
    });
</script>

</body>
</html>
