import numpy as np
import matplotlib.pyplot as plt

data = np.random.normal(5.0, 1.0, 100000)
plt.hist(data, bins=25, density=True, alpha=0.6, color='b')
plt.show()
