from flask import Flask, render_template, request

app = Flask(__name__)

@app.route('/')
def home():
    return render_template('index.html')

@app.route('/phishing')
def phishing():
    return render_template('phishing.html')

@app.route('/capture', methods=['POST'])
def capture():

    username = request.form.get('username', '')

    # Don't display/store real passwords.
    password = request.form.get('password', '')

    return render_template(
        'result.html',
        username=username,
        password=password
    )

@app.route('/digital-arrest')
def digital_arrest():
    return render_template('digital_arrest.html')

if __name__ == '__main__':
    app.run(debug=True)