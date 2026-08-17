from flask import Flask, render_template

app = Flask(__name__)

@app.route('/')
def home():
    return render_template('index.html')

@app.route('/phishing')
def phishing():
    return render_template('phishing.html')

@app.route('/capture', methods=['POST'])
def capture():
    return render_template('result.html')

@app.route('/digital-arrest')
def digital_arrest():
    return render_template('digital_arrest.html')

if __name__ == '__main__':
    app.run(debug=True)