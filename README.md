<h1>Magic-Arena Game</h1>
<p>Magic-Arena is a turn-based strategic game where two players battle until one is defeated. This Java project is designed for simplicity, modularity, and extensibility.</p>

<h2>Game Overview</h2>
<p>Magic-Arena is a player vs. player game where two players take turns attacking and defending using dice rolls and their respective strengths. The outcome of each turn is determined by the players' attributes (health, attack power, and strength) and the results of dice rolls. The game continues until one player is defeated.</p>

<h2>Game Rules</h2>
<ul>
    <li><strong>Initialization:</strong> Each player starts with a set amount of health, attack power, and strength.</li>
    <li><strong>Turns:</strong>
        <ul>
            <li>Players take turns rolling dice to determine their attack and defense values.</li>
            <li>The attacking player rolls to determine their attack damage, while the defending player rolls to determine their defense value.</li>
            <li>The net damage to the defending player is calculated by subtracting the defense value from the attack value.</li>
            <li>The defender's health is reduced by the net damage, ensuring it does not fall below zero.</li>
        </ul>
    </li>
    <li><strong>Victory:</strong> The game continues in rounds until one player's health reaches zero. The surviving player is declared the winner.</li>
</ul>

<h2>Example Gameplay</h2>
<pre>
Player 1 (Alice) attacks Player 2 (Bob).
Alice rolls a dice and calculates an attack value.
Bob rolls a dice and calculates a defense value.
The net damage is applied to Bob's health.
Bob attacks Alice in the next turn, following the same process.
The game continues until one player's health is reduced to zero, and the winner is announced.
</pre>

<h2>Getting Started</h2>

<h3>Prerequisites</h3>
<ul>
    <li>Have IntelliJ IDEA installed on your system.</li>
</ul>

<h3>Installation and Running the Game</h3>
<ol>
    <li><strong>Download and Unzip:</strong>
        <ul>
            <li>Download the project ZIP file.</li>
            <li>Unzip the downloaded file to your desired location.</li>
        </ul>
    </li>
    <li><strong>Open the Project in IntelliJ:</strong>
        <ul>
            <li>Launch IntelliJ IDEA.</li>
            <li>Go to <code>File &gt; Open</code>.</li>
            <li>Navigate to the extracted project directory.</li>
            <li>Select the folder containing the project files <code>Magic-Arena</code> and click <strong>OK</strong>.</li>
        </ul>
    </li>
    <li><strong>Compile and Run the Game:</strong>
        <ul>
            <li>Locate the <code>Main.java</code> file in the <code>main</code> folder inside the <code>src</code> directory.</li>
            <li>Compile the project by running:
                <pre>mvn compile</pre>
            </li>
            <li>Right-click <code>Main.java</code> and select <strong>Run</strong> to start the game.</li>
        </ul>
    </li>
</ol>

<h2>Sequence Diagram</h2>
<p>The sequence diagram below represents the flow of a game round, showing interactions between the <code>GameEngine</code>, <code>Player</code>, and <code>DiceRoller</code> classes.</p>
<img src="https://i.ibb.co/hRMMRnr/sequence.png" alt="Sequence Diagram">


<h2>Unit Test Cases</h2>
<p>The project includes comprehensive unit tests for all major components:</p>
<ul>
    <li><strong>PlayerTest:</strong> Tests for player creation, health management, and game logic.</li>
    <li><strong>DiceTest:</strong> Verifies the dice rolls and randomness.</li>
    <li><strong>GameEngineTest:</strong> Tests the game logic, rounds, and winner announcement.</li>
    <li><strong>BattleTest:</strong> Ensures correct handling of turns and damage calculations.</li>
</ul>

<h2>Features</h2>
<ul>
    <li>Modular design for easy maintenance and extensibility.</li>
    <li>Custom exceptions for handling game-specific errors.</li>
    <li>Comprehensive unit testing to ensure code reliability.</li>
</ul>

<h2>Potential Enhancements</h2>
<ul>
    <li>Add support for multiplayer or AI opponents.</li>
    <li>Include additional game modes or power-ups.</li>
    <li>Integrate a graphical user interface (GUI) for an enhanced user experience.</li>
</ul>


<h2>Author</h2>
<p>Developed by Deepika</p>

