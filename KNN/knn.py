import pandas as pd
iris = pd.read_csv("https://archive.ics.uci.edu/ml/machine-learning-databases/iris/iris.data", header=None)
iris.head()

iris.columns = [
                "sepal length",
                "sepal width",
                "petal lenght",
                "petal width",
                "class",
]

iris = iris.drop("class", axis=1)

iris.head()

import matplotlib.pyplot as plt
iris["petal lenght"].hist(bins=15)
plt.show()

correlation_matrix = iris.corr()
correlation_matrix["petal lenght"]

X = iris.drop("petal lenght", axis=1)
X = X.values
y = iris["petal lenght"]
y = y.values

iris.head()

import numpy as np
new_data_point = np.array([4.9, 3.6, 0.1])

distances = np.linalg.norm(X - new_data_point, axis=1)

k = 3
nearest_neighbor_ids = distances.argsort()[:k]
nearest_neighbor_ids

nearest_neighbor_petal_lenght = y[nearest_neighbor_ids]
nearest_neighbor_petal_lenght

prediction = nearest_neighbor_petal_lenght.mean()

import scipy.stats
class_neighbors = np.array(["Iris Setosa", "Iris Versicolour", "Iris Virginica"])
scipy.stats.mode(class_neighbors)

from sklearn.model_selection import train_test_split
X_train, X_test, y_train, y_test = train_test_split(
    X, y, test_size=0.2, random_state=12345
)

from sklearn.neighbors import KNeighborsRegressor
knn_model = KNeighborsRegressor(n_neighbors=3)

knn_model.fit(X_train, y_train)

from sklearn.metrics import mean_squared_error
from math import sqrt
train_preds = knn_model.predict(X_train)
mse = mean_squared_error(y_train, train_preds)
rmse = sqrt(mse)
rmse

test_preds = knn_model.predict(X_test)
mse = mean_squared_error(y_test, test_preds)
rmse = sqrt(mse)
rmse

import seaborn as sns
cmap = sns.cubehelix_palette(as_cmap=True)
f, ax = plt.subplots()
points = ax.scatter(
     X_test[:, 0], X_test[:, 1], c=test_preds, s=50, cmap=cmap
 )
f.colorbar(points)
plt.show()

cmap = sns.cubehelix_palette(as_cmap=True)
f, ax = plt.subplots()
points = ax.scatter(
     X_test[:, 0], X_test[:, 1], c=y_test, s=50, cmap=cmap
)
f.colorbar(points)
plt.show()

from sklearn.model_selection import GridSearchCV
parameters = {"n_neighbors": range(1, 50)}
gridsearch = GridSearchCV(KNeighborsRegressor(), parameters)
gridsearch.fit(X_train, y_train)

gridsearch.best_params_

train_preds_grid = gridsearch.predict(X_train)
train_mse = mean_squared_error(y_train, train_preds_grid)
train_rmse = sqrt(train_mse)
test_preds_grid = gridsearch.predict(X_test)
test_mse = mean_squared_error(y_test, test_preds_grid)
test_rmse = sqrt(test_mse)
train_rmse

test_rmse

parameters = {
     "n_neighbors": range(1, 50),
     "weights": ["uniform", "distance"],
}
gridsearch = GridSearchCV(KNeighborsRegressor(), parameters)
gridsearch.fit(X_train, y_train)

gridsearch.best_params_

test_preds_grid = gridsearch.predict(X_test)
test_mse = mean_squared_error(y_test, test_preds_grid)
test_rmse = sqrt(test_mse)
test_rmse

best_k = gridsearch.best_params_["n_neighbors"]
best_weights = gridsearch.best_params_["weights"]
bagged_knn = KNeighborsRegressor(
     n_neighbors=best_k, weights=best_weights
)

from sklearn.ensemble import BaggingRegressor
bagging_model = BaggingRegressor(bagged_knn, n_estimators=100)

test_preds_grid = bagging_model.predict(X_test)
test_mse = mean_squared_error(y_test, test_preds_grid)
test_rmse = sqrt(test_mse)
test_rmse