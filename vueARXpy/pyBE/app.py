#  if you run: payhton3 app.py
#  then open http://localhost:5000/arx
#  you should get "Welcome to ARX!"

from flask import Flask, jsonify
from flask_cors import CORS


# configuration
DEBUG = True

# instantiate the app
app = Flask(__name__)
app.config.from_object(__name__)

# enable CORS
CORS(app, resources={r'/*': {'origins': '*'}})

# sanity check route
@app.route('/arx', methods=['GET'])
def getArx():
    return jsonify('Welcome to ARX!!!')

if __name__ == '__main__':
    app.run()
