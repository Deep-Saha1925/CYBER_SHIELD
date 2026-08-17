from flask import Flask, render_template

app = Flask(__name__)

@app.route('/')
def home():
    return render_template('index.html')

@app.route('/phishing')
def phishing():
    return """
    <h1>Phishing Simulation</h1>
    <p>This page represents the website a victim might reach after clicking a suspicious link.</p>
    """

if __name__ == '__main__':
    app.run(debug=True)