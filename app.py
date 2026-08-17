from flask import Flask

app = Flask(__name__)

@app.route('/')
def home():
    return """
        <h1>CyberShield</h1>
        <p>Online Fraud Simulation System</p>
    """

if __name__ == '__main__':
    app.run(debug=True)