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

if __name__ == '__main__':
    app.run(debug=True)