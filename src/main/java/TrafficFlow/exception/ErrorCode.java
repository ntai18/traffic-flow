package TrafficFlow.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    ERR_001(1, "test"),
    ERR_002(2, "test"),
    ERR_003(3, "test"),;
    private final int code;
    private final String message;

}
