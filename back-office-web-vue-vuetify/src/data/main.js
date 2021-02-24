const header1 = [
  {text: 'CreateDateTime', value: 'createDateTime', align: 'center',},
  {text: 'Health', value: 'health', align: 'center',},
  {text: 'Server', value: 'server', align: 'center',},
  {text: 'Description', value: 'description', align: 'center',},
  {text: 'Current', value: 'current', align: 'center',},
];

const header2 = [
  {text: 'Agent', value: 'agent', align: 'center',},
  {text: 'Memory', value: 'memory', align: 'center',},
  {text: 'CPU', value: 'cpu', align: 'center',},
  {text: 'Disk', value: 'disk', align: 'center',},
  {text: 'IO', value: 'io', align: 'center',},
  // {text: 'Actions', value: 'actions', sortable: false},
];

const getDate = () => {
  const now = new Date().toISOString();
  const date = now.split('T')[0];
  const time = now.split('T')[1].split('.')[0];
  return `${date} ${time}`;
};

const getRandomDataFromArray = (array) => {
  return array[Math.floor((Math.random() * array.length))];
};

const getRandomPercentageData = () => {
  const percentage = Math.floor(Number(Math.random() * 100));
  return `${percentage} %`;
};

const getRandomIoData = () => {
  const io = Math.floor(Number(Math.random() * 1000));
  return `${io} kb/s`;
};

const healthStatus = ['a', 'b', 'c', 'd', 'e'];
const server = ['INJOS', '114ON', 'IPCC', 'NDAS', 'NDMS', 'WOOSUN'];
const description = ['Memory(Warning)', 'CPU(Warning)', 'DISK(Warning)', 'IO(Warning)'];

const items1 = [
  {
    createDateTime: getDate(),
    health: getRandomDataFromArray(healthStatus),
    server: getRandomDataFromArray(server),
    description: getRandomDataFromArray(description),
    current: getRandomDataFromArray(healthStatus)
  },
  {
    createDateTime: getDate(),
    health: getRandomDataFromArray(healthStatus),
    server: getRandomDataFromArray(server),
    description: getRandomDataFromArray(description),
    current: getRandomDataFromArray(healthStatus)
  },
  {
    createDateTime: getDate(),
    health: getRandomDataFromArray(healthStatus),
    server: getRandomDataFromArray(server),
    description: getRandomDataFromArray(description),
    current: getRandomDataFromArray(healthStatus)
  },
  {
    createDateTime: getDate(),
    health: getRandomDataFromArray(healthStatus),
    server: getRandomDataFromArray(server),
    description: getRandomDataFromArray(description),
    current: getRandomDataFromArray(healthStatus)
  },
  {
    createDateTime: getDate(),
    health: getRandomDataFromArray(healthStatus),
    server: getRandomDataFromArray(server),
    description: getRandomDataFromArray(description),
    current: getRandomDataFromArray(healthStatus)
  },
  {
    createDateTime: getDate(),
    health: getRandomDataFromArray(healthStatus),
    server: getRandomDataFromArray(server),
    description: getRandomDataFromArray(description),
    current: getRandomDataFromArray(healthStatus)
  },
  {
    createDateTime: getDate(),
    health: getRandomDataFromArray(healthStatus),
    server: getRandomDataFromArray(server),
    description: getRandomDataFromArray(description),
    current: getRandomDataFromArray(healthStatus)
  },
  {
    createDateTime: getDate(),
    health: getRandomDataFromArray(healthStatus),
    server: getRandomDataFromArray(server),
    description: getRandomDataFromArray(description),
    current: getRandomDataFromArray(healthStatus)
  },
  {
    createDateTime: getDate(),
    health: getRandomDataFromArray(healthStatus),
    server: getRandomDataFromArray(server),
    description: getRandomDataFromArray(description),
    current: getRandomDataFromArray(healthStatus)
  },
  {
    createDateTime: getDate(),
    health: getRandomDataFromArray(healthStatus),
    server: getRandomDataFromArray(server),
    description: getRandomDataFromArray(description),
    current: getRandomDataFromArray(healthStatus)
  },
  {
    createDateTime: getDate(),
    health: getRandomDataFromArray(healthStatus),
    server: getRandomDataFromArray(server),
    description: getRandomDataFromArray(description),
    current: getRandomDataFromArray(healthStatus)
  },
  {
    createDateTime: getDate(),
    health: getRandomDataFromArray(healthStatus),
    server: getRandomDataFromArray(server),
    description: getRandomDataFromArray(description),
    current: getRandomDataFromArray(healthStatus)
  },
  {
    createDateTime: getDate(),
    health: getRandomDataFromArray(healthStatus),
    server: getRandomDataFromArray(server),
    description: getRandomDataFromArray(description),
    current: getRandomDataFromArray(healthStatus)
  },
  {
    createDateTime: getDate(),
    health: getRandomDataFromArray(healthStatus),
    server: getRandomDataFromArray(server),
    description: getRandomDataFromArray(description),
    current: getRandomDataFromArray(healthStatus)
  },
  {
    createDateTime: getDate(),
    health: getRandomDataFromArray(healthStatus),
    server: getRandomDataFromArray(server),
    description: getRandomDataFromArray(description),
    current: getRandomDataFromArray(healthStatus)
  },
  {
    createDateTime: getDate(),
    health: getRandomDataFromArray(healthStatus),
    server: getRandomDataFromArray(server),
    description: getRandomDataFromArray(description),
    current: getRandomDataFromArray(healthStatus)
  },
  {
    createDateTime: getDate(),
    health: getRandomDataFromArray(healthStatus),
    server: getRandomDataFromArray(server),
    description: getRandomDataFromArray(description),
    current: getRandomDataFromArray(healthStatus)
  },
  {
    createDateTime: getDate(),
    health: getRandomDataFromArray(healthStatus),
    server: getRandomDataFromArray(server),
    description: getRandomDataFromArray(description),
    current: getRandomDataFromArray(healthStatus)
  },
  {
    createDateTime: getDate(),
    health: getRandomDataFromArray(healthStatus),
    server: getRandomDataFromArray(server),
    description: getRandomDataFromArray(description),
    current: getRandomDataFromArray(healthStatus)
  },
  {
    createDateTime: getDate(),
    health: getRandomDataFromArray(healthStatus),
    server: getRandomDataFromArray(server),
    description: getRandomDataFromArray(description),
    current: getRandomDataFromArray(healthStatus)
  },
  {
    createDateTime: getDate(),
    health: getRandomDataFromArray(healthStatus),
    server: getRandomDataFromArray(server),
    description: getRandomDataFromArray(description),
    current: getRandomDataFromArray(healthStatus)
  },
  {
    createDateTime: getDate(),
    health: getRandomDataFromArray(healthStatus),
    server: getRandomDataFromArray(server),
    description: getRandomDataFromArray(description),
    current: getRandomDataFromArray(healthStatus)
  },
];

const items2 = [
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
  {
    agent: getRandomDataFromArray(healthStatus),
    memory: getRandomPercentageData(),
    cpu: getRandomPercentageData(),
    disk: getRandomPercentageData(),
    io: getRandomIoData(),
    actions: '',
  },
];

export default {
  header1,
  header2,
  items1,
  items2,
}
