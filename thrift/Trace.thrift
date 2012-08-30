namespace java com.profiler.context.gen

const string CLIENT_SEND = "CS"
const string CLIENT_RECV = "CR"
const string SERVER_SEND = "SS"
const string SERVER_RECV = "SR"

struct Endpoint {
  1: string ip,
  2: i16 port,
  3: string name,
}

struct Annotation {
  1: i64 timestamp,
  2: string value,
  3: optional Endpoint host,
  4: optional i32 duration,
}

struct BinaryAnnotation {
  1: i64 timestamp, 
  2: string key,
  3: binary value,
  4: string annotationType,
  5: optional Endpoint host
}

struct Span {
  1: long mostTraceID
  2: long leastTraceID
  3: string name,
  4: long spanID,
  5: optional long parentSpanId,
  6: list<Annotation> annotations,
  7: list<BinaryAnnotation> binaryAnnotations
  8: optional bool debug = 0
}